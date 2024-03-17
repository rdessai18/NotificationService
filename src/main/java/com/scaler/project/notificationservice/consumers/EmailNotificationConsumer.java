package com.scaler.project.notificationservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.project.notificationservice.consumers.dto.EmailNotificationDto;
import com.scaler.project.notificationservice.email.SecureEmail;
import com.scaler.project.notificationservice.email.util.EmailUtil;
import jakarta.mail.Session;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Properties;


@Component
public class EmailNotificationConsumer {

    private final ObjectMapper objectMapper;

    public EmailNotificationConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = {"emailTopic"}, groupId = "emailNotificationConsumerGroup")
    public void consumeEmailNotificationEvent(String emailMessage){
        EmailNotificationDto emailNotificationDto = null;
        try {
            emailNotificationDto = this.objectMapper.readValue(emailMessage, EmailNotificationDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //sendEmailNotification();
        String toEmail = emailNotificationDto.getTo();
        String subject = emailNotificationDto.getSubject();
        String body = emailNotificationDto.getBody();
        SecureEmail.sendSecureEmail(toEmail, subject, body);
    }

    private void sendEmailNotification() {
        String smtpHostServer = "smtp.example.com";
        String emailID = "email_me@example.com";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", smtpHostServer);

        Session session = Session.getInstance(props, null);
        EmailUtil.sendEmail(session, emailID,"SimpleEmail Testing Subject", "SimpleEmail Testing Body");

    }
}
