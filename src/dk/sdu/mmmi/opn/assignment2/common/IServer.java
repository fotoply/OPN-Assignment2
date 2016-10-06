package dk.sdu.mmmi.opn.assignment2.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created 10/3/16
 */
public interface IServer extends Remote {

    void addEntryUpdateListener(ICatalogListener newListener) throws RemoteException;

    ICatalog getCatalog() throws RemoteException;


}
