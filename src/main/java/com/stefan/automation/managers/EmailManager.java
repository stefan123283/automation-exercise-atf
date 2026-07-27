package com.stefan.automation.managers;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public final class EmailManager {

    private static final String REPORT_SENDER_GMAIL = ConfigReaderManager.getProperty("reportSenderGmail");
    private static final String REPORT_SENDER_APP_PASSWORD = ConfigReaderManager.getProperty("reportSenderAppPassword");
    private static final String REPORT_RECEIVER_GMAIL = ConfigReaderManager.getProperty("reportReceiverGmail");

    private EmailManager() {
    }

    public static void sendTestReport(String reportPath) {
        // SMTP server properties
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");

        //Create a session with authentification
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(REPORT_SENDER_GMAIL, REPORT_SENDER_APP_PASSWORD);
            }
        });
//        session.setDebug(true);

        try {
            // Create Email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(REPORT_SENDER_GMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(REPORT_RECEIVER_GMAIL));
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
            Log.debug("Sending test report via email address");
            Transport.send(message);
            Log.info("Test report sent successfully");
        } catch (MessagingException e) {
            Log.warn("Unable to send test report via email");
        } catch (IOException e) {
            Log.error("The \"" + reportPath + "\" file was not found or it can't be opened");
        }
    }

}
