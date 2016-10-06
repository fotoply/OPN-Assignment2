package dk.sdu.mmmi.opn.assignment2.testers;

import dk.sdu.mmmi.opn.assignment2.common.IProduct;
import dk.sdu.mmmi.opn.assignment2.common.Product;

import static org.junit.Assert.*;

/**
 * Created 10/6/16
 */
public class ProductTester {
    private IProduct product;

    @org.junit.Before
    public void setUp() throws Exception {
        product = new Product("Test", 1);
    }

    @org.junit.Test
    public void getName() throws Exception {
        assertEquals("Name was incorrect", "Test", product.getName());
    }

    @org.junit.Test
    public void getPrice() throws Exception {
        assertEquals("Price was incorrect", 1, product.getPrice(), 1);
    }

}