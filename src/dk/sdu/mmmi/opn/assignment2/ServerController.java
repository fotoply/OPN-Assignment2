package dk.sdu.mmmi.opn.assignment2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        try {
            startServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private static void startServer() {
        try {
            Registry registry = LocateRegistry.createRegistry(RMI_Config.REGISTRY_PORT);
            registry.bind(RMI_Config.OBJECT_NAME, new ServerController());
        } catch (AlreadyBoundException | RemoteException e) {
            throw new Error("Error when creating server: "+e);
        }
        System.out.println("Server running with registry on port "+RMI_Config.REGISTRY_PORT);
    }
}
