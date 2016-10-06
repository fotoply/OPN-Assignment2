package dk.sdu.mmmi.opn.assignment2.common;

import dk.sdu.mmmi.opn.assignment2.common.IEntry;
import dk.sdu.mmmi.opn.assignment2.common.IProduct;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created 10/6/16
 */
public abstract class AbstractEntry extends UnicastRemoteObject implements IEntry {

    /**
     * The product which this entry concerns
     */
    protected dk.sdu.mmmi.opn.assignment2.common.IProduct IProduct;
    /**
     * The number of products
     */
    protected int quantity;

    public AbstractEntry(int quantity, IProduct IProduct) throws RemoteException {
        super();
        this.quantity = quantity;
        this.IProduct = IProduct;
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
    public abstract boolean updateQuantity(int change);

    /**
     * Get the product
     */
    @Override
    public IProduct getProduct() throws RemoteException {
        return IProduct;
    }
}
