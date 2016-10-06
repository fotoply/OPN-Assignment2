package dk.sdu.mmmi.opn.assignment2.common;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * Created 10/6/16
 */
public abstract class AbstractCatalog extends UnicastRemoteObject implements ICatalog {

    protected static final String[] PRODUCT_NAMES = {
            "cucumber", "carrot", "potato", "pear", "apple", "zucchini", "beet", "onion", "tomato", "orange", "banana", "grapes", "sweet potato",
            "garlic", "lemon", "lime", "cabbage", "corn"
    };
    /**
     * Contents of the catalog
     */
    protected Map<String, IEntry> stock = new HashMap<>();

    public AbstractCatalog() throws RemoteException {
        super();
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
    protected abstract void initializeStock() throws RemoteException;
}
