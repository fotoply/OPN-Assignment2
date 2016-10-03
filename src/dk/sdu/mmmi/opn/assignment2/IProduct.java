package dk.sdu.mmmi.opn.assignment2;

import java.io.Serializable;

/**
 * Created 10/3/16
 *
 * @author Niels Norberg
 */
public interface IProduct extends Serializable {

    String getName();

    float getPrice();
}
