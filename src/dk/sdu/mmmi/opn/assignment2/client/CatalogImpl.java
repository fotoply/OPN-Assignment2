package dk.sdu.mmmi.opn.assignment2.client;

import dk.sdu.mmmi.opn.assignment2.common.AbstractCatalog;
import dk.sdu.mmmi.opn.assignment2.common.Product;

import java.rmi.RemoteException;
import java.util.Random;

/**
 * Implementation of a catalog
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class CatalogImpl extends AbstractCatalog {

    /**
     * Create and initialize the stock
     */
    public CatalogImpl() throws RemoteException {
        super();
        initializeStock();
    }

    @Override
    protected void initializeStock() throws RemoteException {
        Random random = new Random();
        for (String PRODUCT_NAME : PRODUCT_NAMES)
            stock.put(PRODUCT_NAME, new EntryImpl(new Product(PRODUCT_NAME, random.nextInt(1000) / 100.0f), random.nextInt(10)));
    }

}
