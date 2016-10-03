package dk.sdu.mmmi.opn.assignment2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created 10/3/16
 */
public interface ICatalogListener extends Remote {
    void entryUpdated() throws RemoteException;
}
