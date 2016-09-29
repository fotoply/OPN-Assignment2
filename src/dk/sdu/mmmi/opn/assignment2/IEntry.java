package dk.sdu.mmmi.opn.assignment2;

/**
 * Generic interface for an entry containing a product and its corresponding quantity
 * (part of the model layer of the application)
 * @author ups
 */
public interface IEntry {
	int getQuantity();
	boolean updateQuantity(int change);
	Product getProduct();
}
