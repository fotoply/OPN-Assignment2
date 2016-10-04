package dk.sdu.mmmi.opn.assignment2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created 10/3/16
 */
public class ServerController extends UnicastRemoteObject implements IServer {

    private ICatalog catalog;

    public ServerController() throws RemoteException {
        catalog = new ServerListenerCatalog();
        System.out.println("Initialized catalog");
    }

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            Registry registry = LocateRegistry.createRegistry(RMI_Config.REGISTRY_PORT);
            registry.bind(RMI_Config.OBJECT_NAME, new ServerController());
        } catch (AlreadyBoundException | RemoteException e) {
            e.printStackTrace();
            System.out.println("Error at server start: " + e.getMessage());
        }
        System.out.println("Server running on port " + RMI_Config.REGISTRY_PORT);
    }

    @Override
    public void addEntryUpdateListener(ICatalogListener newListener) throws RemoteException {
        for (String entryName : catalog.getEntryNames()) {
            ((ServerListenerEntry) catalog.getEntry(entryName)).addListener(newListener);
        }
    }

    @Override
    public ICatalog getCatalog() throws RemoteException {
        return catalog;
    }
}
