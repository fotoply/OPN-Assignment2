package dk.sdu.mmmi.opn.assignment2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Implementation of a catalog
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class CatalogImpl extends UnicastRemoteObject implements ICatalog {

    private static final String[] PRODUCT_NAMES = {
            "cucumber", "carrot", "potato", "pear", "apple", "zucchini", "beet", "onion", "tomato", "orange", "banana", "grapes", "sweet potato",
            "garlic", "lemon", "lime", "cabbage", "corn"
    };
    /**
     * Contents of the catalog
     */
    private Map<String, IEntry> stock = new HashMap<>();

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
    public IEntry getEntry(String name) {
        return stock.get(name);
    }

    /**
     * Search catalog and return all products that match the given prefix
     */
    @Override
    public List<IProduct> search(String pattern) {
        ArrayList<IProduct> result = stock.entrySet().stream().filter(entry -> entry.getKey().startsWith(pattern)).map(entry -> entry.getValue().getProduct()).collect(Collectors.toCollection(ArrayList::new));
        return result;
    }

    /**
     * Get all names of entries
     */
    @Override
    public Set<String> getEntryNames() {
        return new HashSet<>(stock.keySet());
    }

    /**
     * Initialize stock with dummy products
     */
    private void initializeStock() throws RemoteException {
        Random random = new Random();
        for (int i = 0; i < PRODUCT_NAMES.length; i++)
            stock.put(PRODUCT_NAMES[i], new EntryImpl(new Product(PRODUCT_NAMES[i], random.nextInt(1000) / 100.0f), random.nextInt(10)));
    }

}
