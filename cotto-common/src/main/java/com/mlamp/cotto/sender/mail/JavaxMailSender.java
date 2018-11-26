package com.mlamp.cotto.sender.mail;

import com.sun.mail.smtp.SMTPTransport;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Wraps javax.mail features, mostly because Session is a final class and can't be mocked.
 */
public class JavaxMailSender {

    public static final String PROTOCOL = "smtp";

    private final Session session;
    private final SMTPTransport t;

    public JavaxMailSender(final Properties props)
            throws NoSuchProviderException {
        this.session = Session.getInstance(props, null);
        this.t = (SMTPTransport) this.session.getTransport(PROTOCOL);
    }

    public Message createMessage() {
        return new MimeMessage(this.session);
    }

    public void connect(final String mailHost, final int mailPort, final String mailUser,
                        final String mailPassword) throws MessagingException {
        this.t.connect(mailHost, mailPort, mailUser, mailPassword);
    }

    public void connect() throws MessagingException {
        this.t.connect();
    }

    public void sendMessage(final Message message, final Address[] recipients)
            throws MessagingException {
        this.t.sendMessage(message, recipients);
    }

    public void close() throws MessagingException {
        this.t.close();
    }

}