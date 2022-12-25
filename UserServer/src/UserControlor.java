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

	
	public String Register(String username, String password, String fullname, int age) throws RemoteException, userException{
		User u = new User(username,password,fullname,age);
		if(users.size()<maxUsers) {
			users.add(u);
			return "Registred successfully ! ";
		}else throw( new userException("Sorry! we can not accept more users"));
	}
	public String Login(String username, String password) throws RemoteException, userException{
		Iterator<User> itr = users.iterator();
		boolean found=false;
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				found=true;
				user.setStatus("connected");
			}
		}
		if(found==false){
			throw(new userException("Incorrect username or password! "));
		}else {
			return(new String("login successful ! \n  "));
		}
	}
	
	public String Logout(String username) throws RemoteException{
		boolean found=false;
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getUsername().equals(username)) {
				user.setStatus("disconnected");
				found=true;
			}
		}
		if(found) {
			return "logout successful ! ";
		}else {
			return "logout not successful";
		}
	};
	public String DeleteUser(String username) throws RemoteException{
		boolean found =false;
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			if(itr.next().getUsername().equals(username)) {
				users.remove(itr.next());
				found=true;
			}
		}
		if(found) {
			return "user was deleted successfully !  ";
		}else {
			return "user with given username does not exist";
		}
		
	};
	public String GetUser(String username) throws RemoteException, userException{
		Iterator<User> itr = users.iterator();
		boolean found=false;
		while(itr.hasNext()) {
			if(itr.next().getUsername().equals(username)) {
				found=true;
				User user = itr.next();
				return user.toString(); 
		}
		}
		if(found==false){
			throw(new userException(" User with given username does not exist ! "));
		}else {
			return "";
		}
	};
	
	
}
