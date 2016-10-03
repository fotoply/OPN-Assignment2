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
    public void addEntryUpdateListener(ICatalogListener newListener) {
        listeners.add(newListener);
    }

    @Override
    public ICatalog getCatalog() {
        return catalog;
    }
}
