package com.stefan.automation.managers;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

public class EmailManager {

    public static void sendTestReport(String reportPath) {
        final String senderEmail = "frunzas621@gmail.com";
        final String appPassword = "pikkggyhdxmbydgr";
        final String receiverEmail = "frunzas621@gmail.com";

        // SMTP server properties
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");

        //Create a session with authentification
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, appPassword);
            }
        });
//        session.setDebug(true);

        try {
            // Create Email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Automation Exercise Test Execution Report");

            // Email Body Part
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("Hello,\nThis is an automatic email.\nPlease do not reply.\nRegards,\nQA Team");

            // Attachment Part
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(new File(reportPath));

            //Combine body and attachment parts
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textPart);
            mimeMultipart.addBodyPart(attachmentPart);
            message.setContent(mimeMultipart);

            // Send Email
            Transport.send(message);
            Log.info("Email sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
