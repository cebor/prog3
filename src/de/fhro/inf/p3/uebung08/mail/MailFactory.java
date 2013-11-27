package de.fhro.inf.p3.uebung08.mail;

import de.fhro.inf.p3.uebung08.mail.impl.MailImpl2;

/**
 * User: sid
 * Date: Jan 28, 2003
 * Time: 5:33:05 PM
 * Update: 20.08.2006 Hue: Kommentare
 */

/**
 * Default implementation for the mail factory.
 */
public class MailFactory {
    /**
     * address holds the address to which emails will be sent.
     */
    private MailAddress address;

    /**
     * Constructor that defines the default mail address.
     *
     * @param address the address to send mail to.
     */
    public MailFactory(MailAddress address) {
        this.address = address;
    }

    /**
     * Returns the mail interface to which emails will be sent.
     *
     * @return the mail interface to which emails will be sent
     */
    public IMail getMail() {
        return new MailImpl2(address);
    }
}
