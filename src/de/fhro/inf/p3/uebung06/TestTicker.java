package de.fhro.inf.p3.uebung06;

import junit.framework.TestCase;

import java.util.logging.Logger;

/**
 * Created by felix on 11/7/13.
 */
public class TestTicker extends TestCase {

    private static Logger logger = Logger.getLogger(TestTicker.class.getName());

    public void testTickerClient() {
        Ticker t = new Ticker();
        TickerClient tc1 = new TickerClient("tc1");

        t.addObserver(tc1);

        t.setKurs("DAX", 12.4);
        t.setKurs("ABC", 4.3);
        t.setKurs("CDF", 6.2);
        t.setKurs("FFF", 13.1);
        t.setKurs("DAX", 12.7);
        t.setKurs("DAX", 12.4);
        t.setKurs("FFF", 13.4);

        assertEquals(t.getKurs("DAX"), 12.4);
        assertEquals(t.getKurs("ABC"), 4.3);
        assertEquals(t.getKurs("CDF"), 6.2);
        assertEquals(t.getKurs("FFF"), 13.4);

        logger.info("fertig!");
    }
}
