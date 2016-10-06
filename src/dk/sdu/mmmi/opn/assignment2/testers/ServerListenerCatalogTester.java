package dk.sdu.mmmi.opn.assignment2.testers;

import dk.sdu.mmmi.opn.assignment2.common.ICatalog;
import dk.sdu.mmmi.opn.assignment2.server.IServerListenerNotifier;
import dk.sdu.mmmi.opn.assignment2.server.ServerListenerCatalog;
import dk.sdu.mmmi.opn.assignment2.testers.mockobjects.MockServer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created 10/6/16
 */
public class ServerListenerCatalogTester {
    IServerListenerNotifier server;
    ICatalog catalog;

    @Before
    public void setUp() throws Exception {
        server = new MockServer();
        catalog = new ServerListenerCatalog(server);
    }

    @Test
    public void initializeStock() throws Exception {
        assertEquals("Catalog was empty.", true, catalog.getEntryNames().size() > 0);
    }

}