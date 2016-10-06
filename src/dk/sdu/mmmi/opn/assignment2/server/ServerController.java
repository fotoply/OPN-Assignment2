package dk.sdu.mmmi.opn.assignment2.server;

import dk.sdu.mmmi.opn.assignment2.common.ICatalog;
import dk.sdu.mmmi.opn.assignment2.common.ICatalogListener;
import dk.sdu.mmmi.opn.assignment2.common.IServer;
import dk.sdu.mmmi.opn.assignment2.common.RMI_Config;

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

    private static ServerController instance;
    private ICatalog catalog;
    private List<ICatalogListener> listeners;

    public ServerController() throws RemoteException {
        catalog = new ServerListenerCatalog();
        listeners = new ArrayList<>();
        System.out.println("Initialized catalog");
    }

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        try {
            Registry registry = LocateRegistry.createRegistry(RMI_Config.REGISTRY_PORT);
            registry.bind(RMI_Config.OBJECT_NAME, ServerController.getInstance());
        } catch (AlreadyBoundException | RemoteException e) {
            e.printStackTrace();
            System.out.println("Error at server start: " + e.getMessage());
        }
        System.out.println("Server running on port " + RMI_Config.REGISTRY_PORT);
    }

    public static ServerController getInstance() {
        if (instance == null) {
            try {
                instance = new ServerController();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    void notifyListeners() {
        for (ICatalogListener listener : listeners) {
            try {
                listener.entryUpdated();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addEntryUpdateListener(ICatalogListener newListener) throws RemoteException {
        listeners.add(newListener);
    }

    @Override
    public ICatalog getCatalog() throws RemoteException {
        return catalog;
    }
}
