package de.fhro.inf.p3.uebung08.mail;

import java.io.Serializable;

/**
 * User: Christian Neumann
 * Date: 20.10.2005
 * Time: 15:48:38
 * Update: 20.08.2006 Hue: Kommentare
 */

/**
 * A class that encapsulates the Data of a send mail.
 * This may be used by the interface, the implementation
 * and the user of the mail.
 */
public class MailData implements Serializable {

    private static final long serialVersionUID = 1L;

    private MailAddress mailAddress;
    private String subject;
    /**
     * content holds the text body of the mail.
     */
    private String content;

    /**
     * Constructs a new mail data.
     *
     * @param mailAddress the address of the receiver
     * @param subject     the subject of the mail
     * @param content     the body of the mail
     */
    public MailData(MailAddress mailAddress, String subject, String content) {
        this.mailAddress = mailAddress;
        this.subject = subject;
        this.content = content;
    }

    public MailAddress getMailAddress() {
        return mailAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        MailData md = (MailData) o;

        return mailAddress.equals(md.getMailAddress())
                && subject.equals(md.getSubject()) && content.equals(md.getSubject());
    }

    public int hashCode() {
        final int prime = 31;
        return (mailAddress.hashCode() * prime + subject.hashCode()) * prime + content.hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append(mailAddress.toString()).append(" ");
        sb.append(subject).append(" ");
        sb.append(content);

        return sb.toString();
    }
}

