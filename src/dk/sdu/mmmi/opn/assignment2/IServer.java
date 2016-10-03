package dk.sdu.mmmi.opn.assignment2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

/**
 * Created 10/3/16
 */
public interface IServer extends Remote {

    List<IProduct> searchForProduct(String searchString) throws RemoteException;

    IEntry getEntry(String name) throws RemoteException;

    Set<String> getEntries() throws RemoteException;
}
