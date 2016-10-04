package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.ICatalogListener;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created 10/3/16
 */
public class ServerListenerEntry extends EntryImpl {

    /**
     * Create entry for the given product and with the given quantity
     *
     * @param IProduct
     * @param quantity
     */
    public ServerListenerEntry(dk.sdu.mmmi.opn.assignment2.common.IProduct IProduct, int quantity) throws RemoteException {
        super(IProduct, quantity);
    }

    @Override
    public boolean updateQuantity(int change) {
        boolean success = super.updateQuantity(change);
        ServerController.getInstance().notifyListeners();
        return success;
    }

}
