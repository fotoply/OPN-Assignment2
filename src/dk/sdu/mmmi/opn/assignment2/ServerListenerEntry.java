package dk.sdu.mmmi.opn.assignment2;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created 10/3/16
 */
public class ServerListenerEntry extends EntryImpl {

    private ArrayList<ICatalogListener> listeners = new ArrayList<>();

    /**
     * Create entry for the given product and with the given quantity
     *
     * @param product
     * @param quantity
     */
    public ServerListenerEntry(Product product, int quantity) throws RemoteException {
        super(product, quantity);
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
