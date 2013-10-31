package de.fhro.inf.p3.uebung05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import junit.framework.TestCase;

public class TestMergeSortIterator extends TestCase {
    private static Logger logger = Logger.getLogger(TestMergeSortIterator.class.getName());

    public void testMerge() {

        MergeSortIterator<String> mergeSortIterator = new MergeSortIterator<String>();
        Comparator<String> cmp = new StringComparator();
        List<String> liste1, liste2;

        liste1 = Arrays.asList("aa", "dd", "ee");
        liste2 = Arrays.asList("bb", "cc", "ff", "gg", "hh");

        Iterator<String> it1 = liste1.iterator();
        Iterator<String> it2 = liste2.iterator();

        Iterator<String> it3 = mergeSortIterator.merge(it1, it2, cmp);

        List<String> expected = Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh");

        List<String> actual = new ArrayList<String>();
        while (it3.hasNext()) {
            actual.add(it3.next());
        }
        assertEquals(expected, actual);
        logger.info("Test TestSortIterator fünf Elementen erfolgreich beendet.");

    }

    public void testRemove() {

    }

}

/**
 * Vergleichsfunktion für Strings, die an eine Sortierfunktion übergeben
 * werden kann stützt sich auf Methode compareTo der Schnittstelle
 * Comparable für Strings
 */
class StringComparator implements Comparator<String> {
    public int compare(String x, String y) {
        return x.compareTo(y);
    }
}
