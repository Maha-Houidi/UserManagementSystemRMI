import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUser extends Remote{

	public String Register(String username, String password, String fullname, int age) throws RemoteException, userException;
	public String Login(String username, String password) throws RemoteException, userException;
	public String Logout(String username) throws RemoteException, userException;
	public String DeleteUser(String username) throws RemoteException, userException;
	public String GetUser(String username) throws RemoteException, userException;
	
}
