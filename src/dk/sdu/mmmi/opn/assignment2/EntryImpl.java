package dk.sdu.mmmi.opn.assignment2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implementation of a product entry, with a mutable quantity
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class EntryImpl extends UnicastRemoteObject implements IEntry {

    /**
     * The product which this entry concerns
     */
    private Product product;

    /**
     * The number of products
     */
    private int quantity;

    /**
     * Create entry for the given product and with the given quantity
     */
    public EntryImpl(Product product, int quantity) throws RemoteException {
        super();
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Get the quantity
     */
    @Override
    public int getQuantity() throws RemoteException {
        return quantity;
    }

    /**
     * Change the quantity (positive number implies increase, negative number implies reduction)
     */
    @Override
    public boolean updateQuantity(int change) {
        if (change + quantity < 0) return false;
        quantity += change;
        return true;
    }

    /**
     * Get the product
     */
    @Override
    public Product getProduct() throws RemoteException {
        return product;
    }

}
