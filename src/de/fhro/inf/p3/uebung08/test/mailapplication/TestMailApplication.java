package de.fhro.inf.p3.uebung08.test.mailapplication;

import de.fhro.inf.p3.uebung08.mail.MailAddress;
import de.fhro.inf.p3.uebung08.mailapplication.Configurator;
import junit.framework.TestCase;


/**
 * User: sid
 * Date: Jan 28, 2003
 * Time: 5:36:00 PM
 */

public class TestMailApplication extends TestCase {
    public void testMail() {
        MailAddress address = null;
        try {
            address = new MailAddress("support@fhr-rosenheim.de");
        } catch (Exception e) {
            fail("korrekte mail-adresse abgelehnt");
        }
        Configurator control = new Configurator(address);
    }
}
