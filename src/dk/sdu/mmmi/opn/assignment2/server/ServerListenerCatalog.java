package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.client.CatalogImpl;
import dk.sdu.mmmi.opn.assignment2.common.AbstractCatalog;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * Created 10/3/16
 */
public class ServerListenerCatalog extends AbstractCatalog {

    /**
     * Create and initialize the stock
     */
    public ServerListenerCatalog() throws RemoteException {
        super();
        initializeStock();
    }

    @Override
    protected void initializeStock() throws RemoteException {
        Random random = new Random();
        for (int i = 0; i < PRODUCT_NAMES.length; i++)
            stock.put(PRODUCT_NAMES[i], new ServerListenerEntry(new Product(PRODUCT_NAMES[i], random.nextInt(1000) / 100.0f), random.nextInt(10)));

    }
}
