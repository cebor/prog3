package de.fhro.inf.p3.uebung08.mail.impl;

import de.fhro.inf.p3.uebung08.mail.IMail;
import de.fhro.inf.p3.uebung08.mail.MailAddress;
import de.fhro.inf.p3.uebung08.mail.MailData;

public class MailImpl2 implements IMail {
    private MailAddress address = null;

    /**
     * constructor that has to include the mail address.
     *
     * @param address the mail address to which emails will be sent.
     */
    public MailImpl2(MailAddress address) {
        this.address = address;
    }

    /**
     * Defines how to send emails.
     * Delegates the mail to a Server
     *
     * @param subject the subject of the email
     * @param content the body of the email
     */
    public MailData send(String subject, String content) {
        // send mail to Mail-Server
        MailServer server = new MailServer("mail.fh-rosenheim.de");
        server.send(address, subject, content);

        // return mail data
        return new MailData(address, subject, content);
    }

}
