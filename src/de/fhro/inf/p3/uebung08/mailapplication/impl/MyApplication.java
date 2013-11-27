package de.fhro.inf.p3.uebung08.mailapplication.impl;

import de.fhro.inf.p3.uebung08.mail.IMail;
import de.fhro.inf.p3.uebung08.mail.MailData;

/**
 * User: sid
 * Date: Jan 28, 2003
 * Time: 5:36:48 PM
 * Update: 20.08.2006 Hue: Kommentare
 */

/**
 * Defines a simple application that sends an email.
 */
public class MyApplication {
    /**
     * mail holds the mail interface.
     */
    private IMail mail = null;

    /**
     * Constructs a new application with the right mail interface.
     *
     * @param mail the interface to use for mails
     */
    public MyApplication(IMail mail) {
        this.mail = mail;
    }

    /**
     * Starts the application that uses the mail interface.
     */
    public void start() {
        mail.send("hallo welt", "Das ist unsere erste Komponente");
        MailData md = mail.send("Test MailData", "Test mit Ergebnistyp");
        System.out.println(md.toString());
    }
}
