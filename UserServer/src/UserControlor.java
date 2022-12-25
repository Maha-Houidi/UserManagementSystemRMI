import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import java.util.Iterator;

public class UserControlor extends UnicastRemoteObject implements IUser{

	private static final long serialVersionUID = 1L;
	
	private int maxUsers;
	Vector<User> users = new Vector<User>(maxUsers);
	
	public UserControlor(int max) throws RemoteException {
		super();
		maxUsers= max;
	}

	
	public void Register(String username, String password, String fullname, int age) throws RemoteException, userException{
		User u = new User(username,password,fullname,age);
		if(users.size()<maxUsers) {
			users.add(u);
		}else throw( new userException("Sorry! we can not accept more users"));
	}
	public void Login(String username, String password) throws RemoteException, userException{
		Iterator<User> itr = users.iterator();
		boolean found=false;
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				found=true;
				user.setStatus("connected");
				System.out.println("login successful ! ");
				System.out.println("Welcome "+username+" ! ");
				break;
			}
		}
		if(found==false){
			throw(new userException("Incorrect username or password! "));
		}
	}
	
	public void Logout(String username) throws RemoteException{
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getUsername().equals(username)) {
				user.setStatus("disconnected");
				System.out.println("logout successful ! ");
				System.out.println("Goodbye  ! ");
				break;
			}
		}
	};
	public void DeleteUser(String username) throws RemoteException{
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			if(itr.next().getUsername().equals(username)) {
				users.remove(itr.next());
				System.out.println(" user was deleted successfully ! ");
				break;
			}
		}
	};
	public void ChangePassword(String username,String password) throws RemoteException, userException{
		Iterator<User> itr = users.iterator();
		boolean found=false;
		while(itr.hasNext()) {
			if(itr.next().getUsername().equals(username)) {
				found=true;
				itr.next().setPassword(password);
				System.out.println("password changed successfully ! ");
				break;
			}
		}
		if(found==false){
			throw(new userException("Incorrect username! "));
		}
	};
	
	
}
