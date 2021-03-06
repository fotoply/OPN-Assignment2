package dk.sdu.mmmi.opn.assignment2.common;

/**
 * Product that has a name and a price
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class Product implements IProduct {

    /**
     * Name of the product
     */
    private String name;

    /**
     * Price of the product
     */
    private float price;

    /**
     * Create product with the given name and price
     */
    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get name of product
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Get price of product
     */
    @Override
    public float getPrice() {
        return price;
    }
}
