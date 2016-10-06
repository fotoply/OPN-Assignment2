package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.AbstractEntry;
import dk.sdu.mmmi.opn.assignment2.common.IProduct;

import java.rmi.RemoteException;

/**
 * Created 10/3/16
 * A version of the EntryImpl that will notify the server controller when an update occurs successfully.
 */
public class ServerListenerEntry extends AbstractEntry {

    IServerListenerNotifier server;

    public ServerListenerEntry(IProduct iProduct, int quantity, IServerListenerNotifier server) throws RemoteException {
        super(quantity, iProduct);
        this.server = server;
    }

    @Override
    public boolean updateQuantity(int change) {
        if (change + quantity < 0) return false;
        quantity += change;
        try {
            server.notifyListeners();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }

}
