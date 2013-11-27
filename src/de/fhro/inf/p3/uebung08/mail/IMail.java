package de.fhro.inf.p3.uebung08.mail;

/* User: sid
 * Date: Jan 28, 2003
 * Update: 20.08.2006 Hue: Kommentare
 */

/**
 * Defines the minimal interface to send an email to a defined receiver,
 * only using a subject and body.
 */
public interface IMail {
    /**
     * Defines the only method that implementations of this interface have to
     * implement.
     *
     * @param subject the subject of the email to send
     * @param content the text body of the email to send
     */
    MailData send(String subject, String content);
}
