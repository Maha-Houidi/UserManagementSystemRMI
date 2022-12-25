import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
	public static void main (String [] args) {
		try {
			LocateRegistry.createRegistry(1099);
			UserControlor uc = new UserControlor(10);
			Naming.rebind("rmi://localhost:1099/BK", uc);
			System.out.println("server running...");
		}catch(Exception e ) {
			System.err.println("error d'initialisation du serveur : "+e);
		}
	}

}
