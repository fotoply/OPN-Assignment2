package dk.sdu.mmmi.opn.assignment2.testers.mockobjects;

import dk.sdu.mmmi.opn.assignment2.common.IProduct;

/**
 * Created 10/6/16
 */
public class MockProduct implements IProduct {

    @Override
    public String getName() {
        return "mock";
    }

    @Override
    public float getPrice() {
        return 0;
    }
}
