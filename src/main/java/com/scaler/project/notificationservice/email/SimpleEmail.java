package com.scaler.project.notificationservice.email;

import com.scaler.project.notificationservice.email.util.EmailUtil;
import jakarta.mail.Session;

import java.util.Properties;

public class SimpleEmail {
    public void sendEmail(){
        String smtpHostServer = "smtp.example.com";
        String emailID = "email_me@example.com";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);

        EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");

    }
}
