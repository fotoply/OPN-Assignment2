package dk.sdu.mmmi.opn.assignment2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Set;

/**
 * Created 10/3/16
 */
public class ServerController extends UnicastRemoteObject{

    private ICatalog catalog;

    public ServerController() throws RemoteException {
        catalog = new CatalogImpl();
    }

    public List<IProduct> searchForProduct(String searchString) throws RemoteException{
        return catalog.search(searchString);
    }

    public IEntry getEntry(String name) throws RemoteException {
        return catalog.getEntry(name);
    }

    public Set<String> getEntries() throws RemoteException {
        return catalog.getEntryNames();
    }
}
