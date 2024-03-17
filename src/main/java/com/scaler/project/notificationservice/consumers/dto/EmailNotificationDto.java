package com.scaler.project.notificationservice.consumers.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class EmailNotificationDto implements Serializable {
    private String from;
    private String to;
    private String body;
    private String subject;
}
