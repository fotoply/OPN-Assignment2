package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.ICatalogListener;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created 10/3/16
 */
public class ServerListenerEntry extends EntryImpl {

    private List<ICatalogListener> listeners = new ArrayList<>();

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
        listeners.forEach(iCatalogListener -> {
            try {
                iCatalogListener.entryUpdated();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });
        return success;
    }

    public void addListener(ICatalogListener newListener) {
        listeners.add(newListener);
    }
}
