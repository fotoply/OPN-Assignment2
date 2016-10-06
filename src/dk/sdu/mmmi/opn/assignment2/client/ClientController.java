package dk.sdu.mmmi.opn.assignment2.client;

import dk.sdu.mmmi.opn.assignment2.common.*;

import javax.swing.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Controller for the application
 *
 * @author ups
 */
public class ClientController extends UnicastRemoteObject implements ICatalogListener {

    private static IServer server;
    /**
     * Singleton pattern instance
     */
    private static ClientController instance;
    /**
     * The area in which text can be displayed
     */
    private JTextPane displayArea;
    /**
     * The label in which the current status can be displayed
     */
    private JLabel statusLabel;
    /**
     * The catalogue being manipulated
     */
    private ICatalog catalogue;

    /**
     * Initialize, including connecting to a specific catalogue
     */
    private ClientController() throws RemoteException {
        super();
        server = connectToServer("localhost");
        if(server != null) {
            subscribeToServer(server);
        }
        catalogue = server.getCatalog();
    }

    /**
     * Singleton pattern access method
     */
    public static synchronized ClientController get() {
        if (instance == null) try {
            instance = new ClientController();
        } catch (RemoteException e) {
            System.out.println("Unable to connect to localhost server");
        }
        return instance;
    }

    protected IServer connectToServer(String serverName) {
        System.out.println("Connecting to server at: " + serverName);
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry(serverName, RMI_Config.REGISTRY_PORT);
            IServer server = (IServer) registry.lookup(RMI_Config.OBJECT_NAME);
            System.out.println("Server connection successful");
            return server;
        } catch (RemoteException | NotBoundException e) {
            throw new Error("Error when connecting to server: " + e);
        }
    }

    private void subscribeToServer(IServer server) throws RemoteException {
        server.addEntryUpdateListener(this);
    }

    /**
     * Increase button clicked in GUI
     */
    public void increaseAction(String productName, String amountText) throws RemoteException {
        changeEntry(productName, amountText, true);
    }

    /**
     * Decrease button clicked in GUI
     */
    public void decreaseAction(String productName, String amountText) throws RemoteException {
        changeEntry(productName, amountText, false);
    }

    /**
     * Helper: generic implementation of the increase/decrease action
     */
    private void changeEntry(String productName, String amountText, boolean increase) throws RemoteException {
        int amount = Integer.parseInt(amountText);
        IEntry entry = catalogue.getEntry(productName);
        if (entry == null) {
            setStatus("No such entry: " + productName);
            return;
        }
        if (entry.updateQuantity(increase ? amount : -amount)) // Returns true if success
            updateDisplay();
        else
            setStatus("Negative stock not allowed");
    }

    /**
     * Show the status to the user
     */
    private void setStatus(String status) {
        if (statusLabel == null) throw new Error("Internal error: unable to display status");
        statusLabel.setText(status);
    }

    /**
     * Update display, showing the current entries and their total value
     */
    private void updateDisplay() throws RemoteException {
        // Check that controller is properly initialized
        if (catalogue == null) throw new Error("Internal error: catalogue not set");
        if (displayArea == null) throw new Error("Internal error: display area not set");
        // Then do the display
        StringBuilder result = new StringBuilder();
        float value = 0;
        // For each item in the stock, add it to the description list and the total value
        for (String name : catalogue.getEntryNames()) {
            IEntry entry = catalogue.getEntry(name);
            IProduct IProduct = entry.getProduct();
            result.append(IProduct.getName()).append("@").append(IProduct.getPrice()).append(": ").append(entry.getQuantity()).append("\n");
            value += entry.getQuantity() * IProduct.getPrice();
        }
        result.append("Total value: ").append(value);
        displayArea.setText(result.toString());
    }

    /**
     * Search button clicked in GUI: use text area to show matching products
     */
    public void searchAction(String prefix) throws RemoteException {
        StringBuilder result = new StringBuilder();
        for (IProduct IProduct : catalogue.search(prefix)) {
            result.append(IProduct.getName()).append("\n");
        }
        displayArea.setText(result.toString());
    }

    /**
     * Clear button clicked in GUI: go back to inventory display
     */
    public void clearAction() throws RemoteException {
        updateDisplay();
    }

    /**
     * Set the inventory display object
     * (Note: high coupling, ideally use observer instead)
     */
    public void setInventoryDisplay(JTextPane entriesDisplay) throws RemoteException {
        this.displayArea = entriesDisplay;
        updateDisplay();
    }

    /**
     * Set the status display object
     * (Note: high coupling, ideally use observer instead)
     */
    public void setStatusArea(JLabel label) {
        this.statusLabel = label;
        setStatus("Ready");
    }

    @Override
    public void entryUpdated() throws RemoteException {
        updateDisplay();
    }
}
