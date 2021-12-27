package io.olen4ixxx.investing.util;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class MailSender {
    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_EMAIL = "projectmailing@yandex.ru";

    public static void sendEmail(String toEmail, String subject, String text) throws MessagingException { // TODO: 26.12.2021
        Properties properties = PropertiesInitializer.initProperties();

        Session session = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(DEFAULT_EMAIL));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject(subject);
        message.setText(text);

        Transport transport = session.getTransport();
        String user = properties.getProperty("mail.user");
        String password = properties.getProperty("mail.password");
        transport.connect(user, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
