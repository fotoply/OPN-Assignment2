package dk.sdu.mmmi.opn.assignment2.testers;

import dk.sdu.mmmi.opn.assignment2.common.ICatalog;
import dk.sdu.mmmi.opn.assignment2.server.ServerListenerCatalog;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created 10/6/16
 */
public class ServerListenerCatalogTester {
    ICatalog catalog;

    @Before
    public void setUp() throws Exception {
        catalog = new ServerListenerCatalog();
    }

    @Test
    public void initializeStock() throws Exception {
        assert catalog.getEntryNames().size() > 0;
    }

}