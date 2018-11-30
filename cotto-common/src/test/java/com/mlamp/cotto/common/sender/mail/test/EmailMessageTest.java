package com.mlamp.cotto.common.sender.mail.test;

import com.mlamp.cotto.sender.mail.EmailMessage;
import com.mlamp.cotto.sender.mail.EmailMessageCreator;
import com.mlamp.cotto.sender.mail.JavaxMailSender;
import org.junit.Before;
import org.junit.Test;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;

public class EmailMessageTest {
    private final String host = "mail.xxxxx.com";
    private final int port = 25;
    private final String sender = "xxx@xxxx.com";
    private final String user = "xxxx";
    private final String password = "";
    private final String toAddr = "xxxx@xxxxx.com";

    private EmailMessage em;
    private JavaxMailSender mailSender;
    private Message mimeMessage;
    private Address[] addresses;
    private EmailMessageCreator creator;

    @Before
    public void setUp() throws Exception {
        this.creator = mock(EmailMessageCreator.class);
        this.mailSender = mock(JavaxMailSender.class);
        this.mimeMessage = mock(Message.class);
        this.addresses = new Address[]{new InternetAddress(this.toAddr, false)};
        when(this.creator.createSender(any())).thenReturn(this.mailSender);
        when(this.mailSender.createMessage()).thenReturn(this.mimeMessage);
        when(this.mimeMessage.getRecipients(Message.RecipientType.TO)).thenReturn(this.addresses);
        this.em = new EmailMessage(this.host, this.port, this.user, this.password, this.creator);
    }

    @Test
    public void testSendEmail() throws Exception {
        this.em.setTLS("true");
        this.em.addToAddress(this.toAddr);
        this.em.setFromAddress(this.sender);
        this.em.setSubject("azkaban test email");
        this.em.setBody("azkaban test email");
        this.em.sendEmail();
        verify(this.mimeMessage).addRecipient(Message.RecipientType.TO, this.addresses[0]);
        verify(this.mailSender).sendMessage(this.mimeMessage, this.addresses);
    }


}
