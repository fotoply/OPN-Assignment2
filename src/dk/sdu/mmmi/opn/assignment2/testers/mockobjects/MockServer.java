package dk.sdu.mmmi.opn.assignment2.testers.mockobjects;

import dk.sdu.mmmi.opn.assignment2.client.CatalogImpl;
import dk.sdu.mmmi.opn.assignment2.common.ICatalog;
import dk.sdu.mmmi.opn.assignment2.common.ICatalogListener;

import java.rmi.RemoteException;

/**
 * Created 10/6/16
 */
public class MockServer implements dk.sdu.mmmi.opn.assignment2.common.IServer {

    @Override
    public void addEntryUpdateListener(ICatalogListener newListener) throws RemoteException {

    }

    @Override
    public ICatalog getCatalog() throws RemoteException {
        return new CatalogImpl();
    }

    @Override
    public void notifyListeners() throws RemoteException {

    }
}
