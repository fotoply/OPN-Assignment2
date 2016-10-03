package dk.sdu.mmmi.opn.assignment2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

/**
 * Created 10/3/16
 */
public interface IServer extends Remote {

    void addEntryUpdateListener(ICatalogListener newListener) throws RemoteException;

    ICatalog getCatalog() throws RemoteException;
}
