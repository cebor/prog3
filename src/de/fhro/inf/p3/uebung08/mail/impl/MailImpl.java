package de.fhro.inf.p3.uebung08.mail.impl;

import de.fhro.inf.p3.uebung08.mail.IMail;
import de.fhro.inf.p3.uebung08.mail.MailAddress;
import de.fhro.inf.p3.uebung08.mail.MailData;


/**
 * User: Hue
 * Date: 30.10.2007
 */

/**
 * Default implementation for the mail interface.
 */
public class MailImpl implements IMail {
    private MailAddress address = null;

    /**
     * constructor that has to include the mail address.
     *
     * @param address the mail address to which emails will be sent.
     */
    public MailImpl(MailAddress address) {
        this.address = address;
    }

    /**
     * Defines how to send emails. Does nothing at the moment, just output on console.
     *
     * @param subject the subject of the email
     * @param content the body of the email
     */
    public MailData send(String subject, String content) {
        // send mail
        System.out.println(address + ":\n " + subject + "\n " + content);

        // return mail data
        return new MailData(address, subject, content);
    }
}
