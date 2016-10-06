package dk.sdu.mmmi.opn.assignment2.common;

import dk.sdu.mmmi.opn.assignment2.common.IProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Product that has a name and a price
 * (part of the model layer of the application)
 *
 * @author ups
 */
public class Product implements IProduct {

    private StringProperty property = new SimpleStringProperty("");

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
