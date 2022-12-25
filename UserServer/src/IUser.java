import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote{

	public void Register(String username, String password, String fullname, int age) throws RemoteException, userException;
	public void Login(String username, String password) throws RemoteException, userException;
	public void Logout(String username) throws RemoteException, userException;
	public void DeleteUser(String username) throws RemoteException, userException;
	public void ChangePassword(String username,String password) throws RemoteException, userException;
	
}
