/**
 * User: sid
 * Date: Feb 4, 2003
 * Time: 4:08:24 PM
 */
package de.fhro.inf.p3.uebung09;

import junit.framework.TestCase;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class TestBestellung extends TestCase {
    private final static Logger logger = Logger.getLogger(TestBestellung.class.getName());

    private IKunde k1, k2, k3;
    private Adresse a1, a2, a3;

    public void setUp() {
        a1 = new Adresse("Possenhofener Str. 21",
                "82319",
                "Starnberg",
                "D");
        a2 = new Adresse("Thomas-Dehler-Str. 27",
                "81737",
                "München",
                "D");

        a3 = new Adresse("Marienberger Str. 26",
                "83024",
                "Rosenheim",
                "D");

        k1 = new Privatkunde("Müller", "Rudi", new Datum(1980, 4, 1), a1);
        k2 = new Privatkunde("Meier", "Hugo", new Datum(1970, 12, 31), a2);
        k3 = new Firmenkunde("AG", "Prg3", a3);
    }

    public void testToString() {
        logger.info(k1.toString());
        logger.info(k2.toString());
        logger.info(k3.toString());
    }

    public void testBestellung() {
        k1.addBestellung(new Bestellung(new Datum(2006, 2, 14), 1, 3));
        k1.addBestellung(new Bestellung(new Datum(2006, 2, 14), 2, 3));
        k1.addBestellung(new Bestellung(new Datum(2006, 2, 14), 3, 3));

        List<Bestellung> bs = k1.getBestellungen();
        List<Bestellung> cs = k1.getBezahlteBestellungen();
        assertEquals(bs.size(), 3);
        assertEquals(cs.size(), 0);

        Iterator<Bestellung> i = bs.iterator();
        while (i.hasNext()) {
            Bestellung b = (Bestellung) i.next();
            b.zahlung(new Datum(2006, 2, 18));
            logger.info(b.toString());
        }

        cs = k1.getBezahlteBestellungen();
        assertEquals(bs.size(), 3);
        assertEquals(cs.size(), 3);

        i = cs.iterator();
        while (i.hasNext()) {
            Bestellung b = (Bestellung) i.next();
            b.lieferung(Datum.today());
        }
    }
}