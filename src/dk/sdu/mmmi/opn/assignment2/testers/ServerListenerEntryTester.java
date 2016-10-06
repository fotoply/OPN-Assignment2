package dk.sdu.mmmi.opn.assignment2.testers;

import dk.sdu.mmmi.opn.assignment2.common.IEntry;
import dk.sdu.mmmi.opn.assignment2.common.IServer;
import dk.sdu.mmmi.opn.assignment2.server.ServerListenerEntry;
import dk.sdu.mmmi.opn.assignment2.testers.mockobjects.MockProduct;
import dk.sdu.mmmi.opn.assignment2.testers.mockobjects.MockServer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 10/6/16
 */
public class ServerListenerEntryTester {
    IServer server;
    IEntry entry;

    @Before
    public void setUp() throws Exception {
        entry = new ServerListenerEntry(new MockProduct(), 0);
        server = new MockServer();
    }

    @Test
    public void updateQuantity() throws Exception {

    }

}