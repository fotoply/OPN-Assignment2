package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.AbstractEntry;

import java.rmi.RemoteException;

/**
 * Created 10/3/16
 * A version of the EntryImpl that will notify the server controller when an update occurs successfully.
 */
public class ServerListenerEntry extends AbstractEntry {

    public ServerListenerEntry(int quantity, dk.sdu.mmmi.opn.assignment2.common.IProduct IProduct) throws RemoteException {
        super(quantity, IProduct);
    }

    @Override
    public boolean updateQuantity(int change) {
        if (change + quantity < 0) return false;
        quantity += change;
        ServerController.getInstance().notifyListeners();
        return true;
    }

}
