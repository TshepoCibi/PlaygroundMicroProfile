package com.example.playground.notification.sms;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class SmsNotificationDTO implements Serializable {

    private Set<EventDetail> eventDetailList;

    @Override
    public String toString() {
        return "SmsNotificationDTO{" +
                "eventDetailList=" + eventDetailList +
                '}';
    }
}
