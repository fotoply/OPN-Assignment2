package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.ICatalog;
import dk.sdu.mmmi.opn.assignment2.common.IEntry;
import dk.sdu.mmmi.opn.assignment2.common.IProduct;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * Implementation of a catalog
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class CatalogImpl extends UnicastRemoteObject implements ICatalog {

    protected static final String[] PRODUCT_NAMES = {
            "cucumber", "carrot", "potato", "pear", "apple", "zucchini", "beet", "onion", "tomato", "orange", "banana", "grapes", "sweet potato",
            "garlic", "lemon", "lime", "cabbage", "corn"
    };
    /**
     * Contents of the catalog
     */
    protected Map<String, IEntry> stock = new HashMap<>();

    /**
     * Create and initialize the stock
     */
    public CatalogImpl() throws RemoteException {
        super();
        initializeStock();
    }

    /**
     * Lookup entry by name
     */
    @Override
    public IEntry getEntry(String name) throws RemoteException {
        return stock.get(name);
    }

    /**
     * Search catalog and return all products that match the given prefix
     */
    @Override
    public List<IProduct> search(String pattern) throws RemoteException {
        List<IProduct> result = new ArrayList<>();
        for (Map.Entry<String, IEntry> entry : stock.entrySet()) {
            if (entry.getKey().startsWith(pattern)) {
                result.add(entry.getValue().getProduct());
            }
        }
        return result;
    }

    /**
     * Get all names of entries
     */
    @Override
    public Set<String> getEntryNames() throws RemoteException {
        return new HashSet<>(stock.keySet());
    }

    /**
     * Initialize stock with dummy products
     */
    protected void initializeStock() throws RemoteException {
        Random random = new Random();
        for (String PRODUCT_NAME : PRODUCT_NAMES)
            stock.put(PRODUCT_NAME, new EntryImpl(new Product(PRODUCT_NAME, random.nextInt(1000) /  100.0f), random.nextInt(10)));
    }

}
