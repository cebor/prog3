/**
 * Created on 15.04.2004
 *
 * @author Hue nach Vorlagen von Sid / Weigend Zweck: JUnit Test für Sort
 *         (rekursive Methode mit Interface Comparator)
 * letzte Änderung:  2.6.05 / FdR
 */
package de.fhro.inf.p3.uebung05;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class TestMergeSort extends TestCase {
    private static Logger logger = Logger.getLogger(TestMergeSort.class.getName());

    public void testSort() {

        MergeSort<String> mergeSort = new MergeSort<String>();

        Comparator<String> cmp;
        List<String> liste1, liste2;
        cmp = new StringComparator();

        liste1 = Arrays.asList("kk", "vv", "uu", "vv", "aa");
        liste2 = mergeSort.mergeSort(liste1, cmp);
        logger.info(liste2.toString());
        assertTrue(liste2.get(0).equals(liste1.get(4)));
        assertTrue(liste2.get(4).equals(liste1.get(1)));
        logger.info("Test TestSort fünf Elementen erfolgreich beendet.");

        liste1 = Arrays.asList("kk");
        liste2 = mergeSort.mergeSort(liste1, cmp);
        logger.info(liste2.toString());
        assertTrue(liste2.get(0).equals(liste1.get(0)));
        logger.info("Test TestSort mit einem Element erfolgreich beendet.");

        liste1 = Arrays.asList("");
        liste2 = mergeSort.mergeSort(liste1, cmp);
        logger.info(liste2.toString());
        assertTrue(liste2.get(0).equals(liste1.get(0)));
        logger.info("Test TestSort mit leerem Element erfolgreich beendet.");

        liste1 = null;
        liste2 = mergeSort.mergeSort(liste1, cmp);
        logger.info(liste2.toString());
        assertTrue(liste2.size() == 0);
        logger.info("Test TestSort mit leerer Liste erfolgreich beendet.");


    }


    /**
     * Vergleichsfunktion für Strings, die an eine Sortierfunktion übergeben
     * werden kann stützt sich auf Methode compareTo der Schnittstelle
     * Comparable für Strings
     */
    class StringComparator implements Comparator {
        public int compare(Object x, Object y) {
            String sx = (String) x;
            String sy = (String) y;
            return sx.compareTo(sy);
        }
    }
}