package de.fhro.inf.p3.uebung08.test.mail;

import de.fhro.inf.p3.uebung08.mail.MailAddress;
import junit.framework.TestCase;

import java.text.ParseException;
import java.util.logging.Logger;

public class TestMailAddress extends TestCase {

    private static Logger logger = Logger.getLogger(TestMailAddress.class.getName());

    public void testMailAddress() {
        try {
            MailAddress address = new MailAddress("a.b@c.d");
        } catch (ParseException e) {
            fail("korrekte Adress abgelehnt");
        }

        try {
            MailAddress address = new MailAddress("test");
            fail("inkorrekte Adress angenommen");
        } catch (ParseException e) {

        }
    }

    public void testIsValid() {
        assertTrue(MailAddress.isValid("huettl@fh-rosenheim.de"));
        assertTrue(MailAddress.isValid("reiner.huettl@fh-rosenheim.de"));
    }

    public void testToString() {
        try {
            MailAddress address = new MailAddress("huettl@fh-rosenheim.de");
            logger.info(address.toString());
        } catch (ParseException e) {
            fail("korrekte Adress abgelehnt");
        }

    }

    public void testEqualsObject() {
        try {
            MailAddress address = new MailAddress("huettl@fh-rosenheim.de");
            MailAddress address2 = new MailAddress("huettl@fh-rosenheim.de");
            MailAddress address3 = new MailAddress("hue@fh-rosenheim.de");
            assertTrue(address.equals(address2));
            assertFalse(address.equals(address3));
        } catch (ParseException e) {
            fail("korrekte Adress abgelehnt");
        }
    }

    public void testHashCode() {
        try {
            MailAddress address = new MailAddress("huettl@fh-rosenheim.de");
            MailAddress address2 = new MailAddress("huettl@fh-rosenheim.de");
            MailAddress address3 = new MailAddress("hue@fh-rosenheim.de");
            assertEquals(address.hashCode(), address2.hashCode());
            assertFalse(address.hashCode() == address3.hashCode());
        } catch (ParseException e) {
            fail("korrekte Adress abgelehnt");
        }
    }
}
