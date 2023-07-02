# User Management System with RMI

What is RMI?

RMI stands for Remote Method Invocation. It is a mechanism that allows an object residing in one system (JVM) to access an object running on another JVM.
RMI is used to build distributed applications; it provides remote communication between Java programs. It is provided in the package java.rmi.

----------------------------------------------------------------------------------------------------------------------------------------------------------
Architecture of RMI Application

In an RMI application, we write two programs:
  * A server program in which a remote object is created and reference of that object is made available for the client (using the registry).
  * A client program that requests the remote objects on the server and tries to invoke its methods.
 
 
 ---------------------------------------------------------------------------------------------------------------------------------------------------------
 User management system application : 
 
 
 Server side: 
 
  * *Interface IUser* : extends Remote and contains the signature of the remote methods and every method should throw a RemoteException.
  * *Class User* : implements serializable and contains the attributes, constructor , getters and setters to define the user.
  * *Class UserController* : extends UnicastRemoteObject and implements the interface IUser, this class contains the  
implementation of the different methods that the client can invoke.
  * *Exception userException* : it's a customised exception we use to send a specific message for an error. 
  * *Class RMIServer* : it's the main class for the server side that binds the objects in the registry using rebind().
  
  
  Client side :
  
   * *Class ClientRMI* : it fetches the object from the registry using lookup(), then invokes the different remote methods.
   * A copy of the IUser interface and the userException so that the client knows the methods and how to invoke them. 
