/**
 * User: sid
 * Date: Jan 29, 2003
 * Update: 20.08.2006 Hue: Kommentare
 */

package de.fhro.inf.p3.uebung08.mail;

import java.io.Serializable;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that encapsulates the knowledge about a mail address. This may be used
 * by the interface, the implementation and the user of the mail.
 */
public class MailAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * address holds the mail address of the receiver.
     */
    private String address;
    /**
     * pattern defines a more or less complete pattern that checks that
     * email addresses could be valid.
     */
    private static Pattern pattern =
            //Pattern.compile("\\w+(\\.\\w+)*@\\w+(\\.\\w+)*");
            Pattern.compile("(\\w|-)+(\\.(\\w|-)+)*@(\\w|-)+(\\.(\\w|-)+)*");

    /**
     * Creates a new mail address if the given address is valid, throws an
     * exception if it is not valid.
     *
     * @param address the address of the receiver as a string
     * @throws ParseException if something is wrong in the address
     */
    public MailAddress(String address) throws ParseException {
        if (isValid(address))
            this.address = address;
        else
            throw new ParseException("invalid mail address", 0);
    }

    /**
     * Validates if the adress has the right format     *
     *
     * @param address mail-address
     * @return true if adress is valid
     */
    public static boolean isValid(String address) {
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }

    /**
     * Returns the address as string.
     *
     * @return the address as string
     */
    public String toString() {
        return address;
    }

    /**
     * Defines when two addresses are equals.
     *
     * @param x the object that is compared
     * @return true, if the two addresses are equal
     */
    public boolean equals(Object x) {
        if (this == x)
            return true;
        if (null == x) {
            return false;
        }
        if (x.getClass() != MailAddress.class)
            return false;
        MailAddress a = (MailAddress) x;
        return a.address.equals(address);
    }

    /**
     * Defines a simple hash code for the receiver.
     *
     * @return a simple hash code for the receiver
     */
    public int hashCode() {
        return address.hashCode();
    }
}
