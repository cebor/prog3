package de.fhro.inf.p3.uebung04;

import junit.framework.TestCase;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by felix on 10/23/13.
 *
 * TestTreiber
 */
public class TestGenerateXML extends TestCase {

    private final static Logger logger = Logger.getLogger(TestGenerateXML.class.getName());

    public void testOutput() {

        System.out.println(GenerateXML.generateInterfaceDescriptionXML(Comparable.class));
        System.out.println(GenerateXML.generateInterfaceDescriptionXML(List.class));
        System.out.println(GenerateXML.generateInterfaceDescriptionXML(Runnable.class));
        System.out.println(GenerateXML.generateInterfaceDescriptionXML(Comparator.class));

        logger.info("Output successful");


        try {
            System.out.println(GenerateXML.generateInterfaceDescriptionXML(Object.class));
            fail();
        } catch (Exception e) {
            logger.info("Exception erkannt");
        }
    }
}
