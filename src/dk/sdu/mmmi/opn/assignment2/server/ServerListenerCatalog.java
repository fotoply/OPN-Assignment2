package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.AbstractCatalog;
import dk.sdu.mmmi.opn.assignment2.common.Product;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * Created 10/3/16
 */
public class ServerListenerCatalog extends AbstractCatalog {

    IServerListenerNotifier server;

    /**
     * Create and initialize the stock
     */
    public ServerListenerCatalog(IServerListenerNotifier server) throws RemoteException {
        super();
        this.server = server;
        initializeStock();
    }

    @Override
    protected void initializeStock() throws RemoteException {
        Random random = new Random();
        for (String PRODUCT_NAME : PRODUCT_NAMES)
            stock.put(PRODUCT_NAME, new ServerListenerEntry(new Product(PRODUCT_NAME, random.nextInt(1000) / 100.0f), random.nextInt(10), server));

    }
}
