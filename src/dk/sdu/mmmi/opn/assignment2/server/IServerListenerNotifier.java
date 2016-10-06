package dk.sdu.mmmi.opn.assignment2.server;

import java.rmi.RemoteException;

/**
 * Created 10/6/16
 */
public interface IServerListenerNotifier {

    void notifyListeners() throws RemoteException;

}
