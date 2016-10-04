package dk.sdu.mmmi.opn.assignment2;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * Created 10/3/16
 */
public class ServerListenerCatalog extends CatalogImpl {

    /**
     * Create and initialize the stock
     */
    public ServerListenerCatalog() throws RemoteException {
    }

    @Override
    protected void initializeStock() throws RemoteException {
        Random random = new Random();
        for (int i = 0; i < PRODUCT_NAMES.length; i++)
            stock.put(PRODUCT_NAMES[i], new ServerListenerEntry(new Product(PRODUCT_NAMES[i], random.nextInt(1000) / 100.0f), random.nextInt(10)));

    }
}
