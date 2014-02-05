package dog.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoGInterface extends Remote {
	boolean login(String user, String pwd) throws RemoteException;
}
