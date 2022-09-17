package com.example.playground.notification.email;

import lombok.*;

import java.util.Set;


@Getter
@Setter
public class EmailNotificationDTO {
    private Set<EventDetail> eventDetailList;
}
