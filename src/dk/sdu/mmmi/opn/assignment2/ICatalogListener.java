package dk.sdu.mmmi.opn.assignment2;

import java.rmi.Remote;

/**
 * Created 10/3/16
 */
public interface ICatalogListener extends Remote {
    void entryUpdated();
}
