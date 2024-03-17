package com.scaler.project.notificationservice.email;

import com.scaler.project.notificationservice.email.util.EmailUtil;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.util.Properties;

public class SecureEmail {
    public static void sendSecureEmail(String toEmail, String subject, String body){
        final String fromEmail = "rjtdessai@gmail.com"; //requires valid gmail id
        final String password = "jibxiweyrojmdvpj"; // correct password for gmail id

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };

        Session session = Session.getInstance(props, auth);

        EmailUtil.sendEmail(session, toEmail, subject, body);

    }

}
