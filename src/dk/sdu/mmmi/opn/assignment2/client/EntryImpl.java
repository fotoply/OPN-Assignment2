package dk.sdu.mmmi.opn.assignment2.client;

import dk.sdu.mmmi.opn.assignment2.common.AbstractEntry;
import dk.sdu.mmmi.opn.assignment2.common.IProduct;

import java.rmi.RemoteException;

/**
 * Implementation of a product entry, with a mutable quantity
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class EntryImpl extends AbstractEntry {

    /**
     * Create entry for the given product and with the given quantity
     */
    public EntryImpl(IProduct IProduct, int quantity) throws RemoteException {
        super(quantity, IProduct);
    }

    @Override
    public boolean updateQuantity(int change) {
        if (change + quantity < 0) return false;
        quantity += change;
        return true;
    }

}
