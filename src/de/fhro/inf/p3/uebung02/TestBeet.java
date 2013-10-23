package de.fhro.inf.p3.uebung02;

import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 * @author brm
 * @version 2010-10-07
 */
public class TestBeet extends TestCase {
	//	Initialisierung Logger
	private static Logger logger =	Logger.getLogger(TestBeet.class.getName());
	
	private Beet beet;
	private Blume blume1;
	private Blume blume2;
	private Blume blume3; 
	private Blume blume4; 
	private Blume blume5; 
	private Blume blume6; 	
	private Strauch strauch1;
	
	
	
	public void setUp(){
		beet = new Beet(Pflanze.HUMUS);
		
		blume1 = new Blume("RoteRose", 100, Pflanze.HUMUS, Pflanze.ROT);
		blume2 = new Blume("Sonnenblume", 120, Pflanze.HUMUS, Pflanze.GELB);
		blume3 = new Blume("Gerbera", 20, Pflanze.HUMUS, Pflanze.ROT);
		blume4 = new Blume("Gänseblümchen", 7, Pflanze.HUMUS, Pflanze.WEISS);
		blume5 = new Blume("Löwenzahn", 25, Pflanze.HUMUS, Pflanze.GELB);
		blume6 = new Blume("Aster", 60, Pflanze.LEHM, Pflanze.ROT);
		strauch1 = new Strauch("Ginster", 200, Pflanze.HUMUS );		
	}
	
	public void testBeet() {

		// test addPflanze und getAnzahlPflanzen
		assertTrue(beet.addPflanze(blume1));
		assertEquals(beet.getAnzahlPflanzen(), 1);
		assertTrue(beet.addPflanze(blume2));
		assertEquals(beet.getAnzahlPflanzen(), 2);
		assertTrue(beet.addPflanze(blume3));
		assertEquals(beet.getAnzahlPflanzen(), 3);
		assertTrue(beet.addPflanze(1, blume4));
		assertEquals(beet.getAnzahlPflanzen(), 4);
		assertTrue(beet.addPflanze(blume5));
		assertEquals(beet.getAnzahlPflanzen(), 5);
		assertFalse(beet.addPflanze(blume6));
		assertEquals(beet.getAnzahlPflanzen(), 5);
		assertTrue(beet.addPflanze(strauch1));
		assertEquals(beet.getAnzahlPflanzen(), 6);
		
		// test getBodenart
		assertEquals(beet.getBodenart(), Pflanze.HUMUS);
		
		// test getPflanze und removePflanze
		assertEquals(beet.getPflanze(0), blume1);
		assertEquals(beet.getPflanze(2), blume2);
		assertEquals(beet.removePflanze(1), blume4);
		assertEquals(beet.getPflanze(1), blume2);
		assertEquals(beet.getAnzahlPflanzen(), 5);
		
		// test add mit Postion und remove
		assertTrue(beet.addPflanze(0, blume4));
		assertFalse(beet.addPflanze(7, blume4));
		assertEquals(beet.getPflanze(0), blume4);
		assertEquals(beet.getPflanze(2), blume2);
		assertEquals(beet.removePflanze(0), blume4);		
		
		// test getAnzahlFarben
		// hier sollten noch blume1, blume2, blume3, blume5, strauch1 im beet sein
		assertEquals(beet.getAnzahlFarben(), 3); // ROT, GELB, GRÜN
		
		// test sortByHeight
		logger.info(beet.toString());
		beet.sortByHeight();
		logger.info(beet.toString());
		assertEquals(beet.getPflanze(0), blume3);
		assertEquals(beet.getPflanze(1), blume5);
		assertEquals(beet.getPflanze(2), blume1);
		assertEquals(beet.getPflanze(3), blume2);
		assertEquals(beet.getPflanze(4), strauch1);
		
		logger.info("TestBeet efolgreich bestanden");
	}
}
