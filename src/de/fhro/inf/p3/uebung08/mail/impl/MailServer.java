package de.fhro.inf.p3.uebung08.mail.impl;

import de.fhro.inf.p3.uebung08.mail.MailAddress;

public class MailServer {
    private String name;

    public MailServer(String n) {
        name = n;
    }

    public void send(MailAddress address, String subject, String content) {
        System.out.println("Mail Server: " + name);
        System.out.println(address + ":\n " + subject + "\n " + content);
    }

}
