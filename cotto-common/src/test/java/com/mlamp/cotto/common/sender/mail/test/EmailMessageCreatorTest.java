package com.mlamp.cotto.common.sender.mail.test;

import com.mlamp.cotto.core.Props;
import com.mlamp.cotto.sender.mail.EmailMessage;
import com.mlamp.cotto.sender.mail.EmailMessageCreator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailMessageCreatorTest {
    private static final String HOST = "smtp.domain.com";
    private static final int MAIL_PORT = 25;
    private static final String SENDER = "xxxxx@163.com";
    private static final String USER = "xxxx";
    private static final String PASSWORD = "xxxxx";

    @Test
    public void createMessage() {

        final Props props = new Props();
        props.put("mail.user", USER);
        props.put("mail.sender", SENDER);
        props.put("mail.password", PASSWORD);
        props.put("mail.host", HOST);
        props.put("mail.port", MAIL_PORT);
        final EmailMessageCreator creator = new EmailMessageCreator(props);
        final EmailMessage message = creator.createMessage();
        assertThat(message.getMailPort()).isEqualTo(MAIL_PORT);
        assertThat(message.getBody()).isEmpty();
        assertThat(message.getSubject()).isNull();
    }
}
