/**
 * Created on 	15.04.2004
 * @author  	Hue / FdR  nach Vorlagen von Sid / Weigend
 * Zweck:		JUnit Test für Anagram Beispiele für Stringoperationen und Interface Comparable
 */
package de.fhro.inf.p3.uebung03;

import junit.framework.TestCase;
import junit.framework.Assert;

import java.util.Arrays;
import java.util.logging.Logger;

public class TestAnagram extends TestCase {

    private static Logger logger = Logger.getLogger(TestAnagram.class.getName());;
    private String[] ss = null;

    protected void setUp() {
        ss = new String[]{"anna", "zztt", "aann", "zttz", "otto", "toot", "annz", "znan"};
    }

    public void testAnagram() {
        Anagram a = new Anagram();
        // Vergleich zweier Strings mittels Anagram
        int j = a.compare("anna", "aann");
        Assert.assertTrue(j>0);
        j = a.compare("anna", "anna");
        Assert.assertTrue(j==0);

        // Sortieren eines Arrays von Strings
        Arrays.sort(ss, new Anagram());
        for (int i = 0; i < ss.length -1; i++) {
            logger.info(ss[i]);
            Assert.assertTrue(a.compare(ss[i], ss[i+1]) <= 0);
        }
        
//      try {
//			//j = a.compare(1, 2);
//			j = a.compare(new Integer(1), new Integer(2));
//			fail();
//		} catch (Exception e) {
//			logger.info("Ausnahme erkannt");
//		}
        logger.info("Testanagram erfolgreich! ");
        

    }
}