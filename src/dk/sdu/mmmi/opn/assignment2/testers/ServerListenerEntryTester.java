package dk.sdu.mmmi.opn.assignment2.testers;

import dk.sdu.mmmi.opn.assignment2.common.IEntry;
import dk.sdu.mmmi.opn.assignment2.server.IServerListenerNotifier;
import dk.sdu.mmmi.opn.assignment2.server.ServerListenerEntry;
import dk.sdu.mmmi.opn.assignment2.testers.mockobjects.MockProduct;
import dk.sdu.mmmi.opn.assignment2.testers.mockobjects.MockServer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created 10/6/16
 */
public class ServerListenerEntryTester {
    IServerListenerNotifier server;
    IEntry entry;

    @Before
    public void setUp() throws Exception {
        server = new MockServer();
        entry = new ServerListenerEntry(new MockProduct(), 0, server);
    }

    @Test
    public void updateQuantity() throws Exception {
        entry.updateQuantity(1);
        assertEquals("Quantity was not incerased", 1, entry.getQuantity());
        entry.updateQuantity(-1);
        assertEquals("Quantity was not decreased", 0, entry.getQuantity());
        assertEquals("Quantity is below 0", false, entry.updateQuantity(-1) || entry.getQuantity() == -1);
    }

}