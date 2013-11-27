package de.fhro.inf.p3.uebung08.mailapplication;

import de.fhro.inf.p3.uebung08.mail.IMail;
import de.fhro.inf.p3.uebung08.mail.MailAddress;
import de.fhro.inf.p3.uebung08.mail.MailFactory;
import de.fhro.inf.p3.uebung08.mailapplication.impl.MyApplication;


/**
 * User: Hue
 * Date: 30.10.2007
 */

/**
 * Defines how to configure the mail component together with the application that
 * uses the mail component.
 */
public class Configurator {
    /**
     * application holds the application which will send emails.
     */
    private MyApplication application;

    /**
     * Constructs a new configurator for which the mail factory is defined.
     *
     * @param address defines the factory from which the mail interface will be get
     */
    public Configurator(MailAddress address) {
        MailFactory mailFactory = new MailFactory(address);
        IMail mail = mailFactory.getMail();
        application = new MyApplication(mail);
        application.start();
    }
}
