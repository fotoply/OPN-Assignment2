package dk.sdu.mmmi.opn.assignment2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created 10/3/16
 */
public class ServerController extends UnicastRemoteObject implements IServer {

    private ICatalog catalog;
    private List<ICatalogListener> listeners;

    public ServerController() throws RemoteException {
        catalog = new CatalogImpl();
        listeners = new ArrayList<>();
    }

    @Override
    public List<IProduct> searchForProduct(String searchString) throws RemoteException{
        return catalog.search(searchString);
    }

    @Override
    public IEntry getEntry(String name) throws RemoteException {
        return catalog.getEntry(name);
    }

    @Override
    public Set<String> getEntries() throws RemoteException {
        return catalog.getEntryNames();
    }

    public void addEntryUpdateListener(ICatalogListener newListener) {
        listeners.add(newListener);
    }
}
