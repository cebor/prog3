/*
 * Created by IntelliJ IDEA.
 * User: sid
 * Date: Feb 1, 2002
 * Time: 11:17:36 AM
 */
package de.fhro.inf.p3.uebung03;

import junit.framework.TestCase;
import java.util.*;
import java.util.logging.Logger;

// comments added

public class TestIndex extends TestCase {

    private final static Logger logger = Logger.getLogger(TestIndex.class.getName());

    private List[] book = null;
    private Set[] book1 = null;
    private Set keywords = null;

    public void setUp() {
        book = new List[5];

        book[0] = new ArrayList();
        book[0].add("otto");
        book[0].add("robert");
        book[0].add("hugo");

        // keine Eintraege auf Seite 1
        book[1] = new ArrayList();

        book[2] = new ArrayList();
        book[2].add("otto");
        book[2].add("ernst");
        book[2].add("rudi");

        book[3] = new ArrayList();
        book[3].add("otto");
        book[3].add("hugo");
        book[3].add("jack");

        book[4] = new ArrayList();
        book[4].add("otto");
        book[4].add("susi");
        book[4].add("jack");

        book1 = new HashSet[5];

        for (int i = 0; i < 5; i++) {
            book1[i] = new HashSet(book[i]);
        }

        keywords = new HashSet();
        keywords.add("otto");
        keywords.add("susi");
        keywords.add("jack");
    }


    public void testIndex() {
        Map idx = Index.makeIndex(book);
        logger.info("\n" + idx.toString());
    }

    public void testIndexByKeyWords() {
        Map idx = Index.makeIndex(book, keywords);
        logger.info("\n" + idx.toString());
    }
}

