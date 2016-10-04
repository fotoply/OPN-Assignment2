package dk.sdu.mmmi.opn.assignment2.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Generic interface for an entry containing a product and its corresponding quantity
 * (part of the model layer of the application)
 *
 * @author ups
 */
public interface IEntry extends Remote {
    int getQuantity() throws RemoteException;

    boolean updateQuantity(int change) throws RemoteException;

    IProduct getProduct() throws RemoteException;
}
