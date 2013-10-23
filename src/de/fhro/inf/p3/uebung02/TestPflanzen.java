package de.fhro.inf.p3.uebung02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import junit.framework.TestCase;

/**
 * @author brm
 * @version 2010-10-07
 * changed Hue 2013
 */
public class TestPflanzen extends TestCase {
	private static Logger logger =	Logger.getLogger(TestBeet.class.getName());
	private Collection<Blume> blumen;
	
	public void setUp(){
		blumen = new ArrayList<Blume>();
		blumen.add(new Blume("RoteRose", 100, Pflanze.SAND, Pflanze.ROT));
		blumen.add(new Blume("Sonnenblume", 120, Pflanze.SAND, Pflanze.GELB));
		blumen.add(new Blume("Gerbera", 20, Pflanze.LEHM, Pflanze.ROT));
		blumen.add(new Blume("Gänseblümchen", 7, Pflanze.HUMUS, Pflanze.WEISS));
		blumen.add(new Blume("Löwenzahn", 25, Pflanze.SAND, Pflanze.GELB));
		blumen.add(new Blume("Aster", 60, Pflanze.LEHM, Pflanze.ROT));
		blumen.add(new Blume("Nelke", 15, Pflanze.HUMUS, Pflanze.ROT));
		blumen.add(new Blume("Schneeglöckchen", 10, Pflanze.SAND, Pflanze.WEISS));
		blumen.add(new Blume("Tulpe", 30, Pflanze.HUMUS, Pflanze.GELB));
		blumen.add(new Blume("Tulpe", 25, Pflanze.HUMUS, Pflanze.ORANGE));
	}
	
	public void testTrenneBlumenNachFarbe() {

		List<Blume> roteBlumen = new ArrayList<Blume>();
		List<Blume> gelbeBlumen = new ArrayList<Blume>();
		List<Blume> weisseBlumen = new ArrayList<Blume>();
		List<Blume> orangeBlumen = new ArrayList<Blume>();

		// test der einfachen, aber unflexiblen Implementierung von trenneBlumenNachFarbe
		PflanzenUtil.trenneBlumenNachFarbe(blumen, roteBlumen, gelbeBlumen, weisseBlumen, orangeBlumen);

		assertEquals(roteBlumen.size(), 4);
		assertEquals(gelbeBlumen.size(), 3);
		assertEquals(weisseBlumen.size(), 2);
		assertEquals(orangeBlumen.size(), 1);

		// test der etwas komplexeren, aber flexiblen Implementierung von trenneBlumenNachFarbe
		Map<Integer, List<Blume>> farbsets = PflanzenUtil.trenneBlumenNachFarbe(blumen);
		assertEquals(farbsets.get(Pflanze.ROT).size(), 4);
		assertEquals(farbsets.get(Pflanze.GELB).size(), 3);
		assertEquals(farbsets.get(Pflanze.WEISS).size(), 2);
		assertEquals(farbsets.get(Pflanze.ORANGE).size(), 1);
		
		logger.info("testTrenneBlumenNachFarbe erfolgreich bestanden");
	}
	
	public void testSortByHeight(){
		Blume[] b =  blumen.toArray(new Blume[0]);
		PflanzenUtil.sortByHeight(b);
		assertEquals(b[0].getName(),"Gänseblümchen");
		assertEquals(b[9].getName(),"Sonnenblume");
		logger.info(blumen.toString());
		logger.info("testSortByHeight erfolgreich bestanden");
	}
	
	public void testSortByBoden( ){
		// Umwandlung einer Collection von Blumen in eine Liste von Pflanzen
		List<? extends Pflanze> pflanzen = (List<Blume>) blumen;
		PflanzenUtil.sortByBoden((List<Pflanze>)pflanzen);
		assertTrue(pflanzen.get(0).getBodenart()== Pflanze.SAND);
		assertTrue(pflanzen.get(pflanzen.size()-1).getBodenart()== Pflanze.HUMUS);
		logger.info(blumen.toString());
		logger.info("testSortByBoden erfolgreich bestanden");
	}
	
	public void testKonstruktor(){
		try {
			@SuppressWarnings("unused")
			Blume b = new Blume("GrüneRose", 100, Pflanze.SAND, Pflanze.GRUEN);
			fail();
		} catch (IllegalArgumentException e){
			logger.info("Exception erkannt");
		}
		logger.info("testKonstruktor erfolgreich bestanden");
	}
	
	public void testEqualsHashCode(){
		Blume b1 = new Blume("RoteRose", 100, Pflanze.SAND, Pflanze.ROT);
		Blume b2 = new Blume("RoteRose", 100, Pflanze.SAND, Pflanze.ROT);
		assertTrue(b1.equals(b2));
		assertTrue(b1.hashCode()==b2.hashCode());
		Pflanze p1 = b1;
		assertTrue(p1.equals(b2));
		assertTrue(p1.hashCode()==b2.hashCode());
		Pflanze p2 = b2;
		assertTrue(p1.equals(p2));
		assertTrue(p1.hashCode()==p2.hashCode());
		Blume b3 = new Blume("Rose", 100, Pflanze.SAND, Pflanze.ROT);
		assertFalse(b1.equals(b3));
		b3 = new Blume("RoteRose", 100, Pflanze.SAND, Pflanze.GELB);
		assertFalse(b1.equals(b3));
		
		Strauch s1 = new Strauch("Ginster", 200, Pflanze.HUMUS );
		Strauch s2 = new Strauch("Ginster", 200, Pflanze.HUMUS); 
		assertTrue(s1.equals(s2));
		assertTrue(s1.hashCode()== s2.hashCode());
		
		logger.info("testEquals erfolgreich bestanden");
	}
}
