import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class ClientRMI {

	public static void main(String[] args) {
		BufferedReader in = null;
		String msg = null;
		boolean fin = false;
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			IUser server = (IUser) Naming.lookup("rmi://localhost:1099/BK");
			while (!fin) {
				try {
					System.out.println("What do you want to do?");
					System.out.println("1- Add user");
					System.out.println("2- Login");
					System.out.println("3- Get a user");
					System.out.println("4- Delete user");
					System.out.println("5- Logout");
					System.out.println("6- Exit");
					System.out.println("choice : ");
					msg = in.readLine().toLowerCase().trim();
					System.out.println("");
					
					if(msg.equals("1")) {  //register
						System.out.println("Fullname: ");
						String fn = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(" age: ");
						int age =Integer.parseInt(in.readLine().toLowerCase().trim());
						System.out.println("");
						System.out.println(" username: ");
						String un = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(" password: ");
						String pwd = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(server.Register(un, pwd, fn,age));
					}else if (msg.equals("2")) { //login
						System.out.println(" username: ");
						String un = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(" password: ");
						String pwd = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(server.Login(un, pwd));
					}else if (msg.equals("3")) { //change pwd 
						System.out.println(" username: ");
						String un = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(server.GetUser(un));
					}else if (msg.equals("4")) { //delete user 
						System.out.println(" username: ");
						String un = in.readLine().toLowerCase().trim();
						System.out.println("\n");
						System.out.println(server.DeleteUser(un));
					}else if (msg.equals("5")) { //logout
						System.out.println(" username: ");
						String un = in.readLine().toLowerCase().trim();
						System.out.println("");
						System.out.println(server.Logout(un));
					}else if (msg.equals("6")) {
						fin = true;
					}else{
						System.out.println("please choose from 1 to 6 !");
					}
				}
				catch(Exception e) {
					System.err.println("erreur : "+e);
				}
			}
		}catch(Exception e ) {
			System.err.println("erreur : "+e);	
		}

	}

}
