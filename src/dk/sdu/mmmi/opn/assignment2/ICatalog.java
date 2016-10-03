package dk.sdu.mmmi.opn.assignment2;

import java.util.List;
import java.util.Set;

/**
 * Generic interface to a catalog of entries
 * (part of the model layer of the application)
 *
 * @author ups
 */
public interface ICatalog {
    /**
     * Get all names of entries
     */
    Set<String> getEntryNames();

    /**
     * Lookup entry by name
     */
    IEntry getEntry(String name);

    /**
     * Search catalog and return all products that match the given prefix
     */
    List<IProduct> search(String prefix);
}
