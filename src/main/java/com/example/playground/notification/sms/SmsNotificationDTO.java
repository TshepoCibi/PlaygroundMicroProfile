package com.example.playground.notification.sms;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class SmsNotificationDTO implements Serializable {

    private Set<EventDetail> eventDetailList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsNotificationDTO)) return false;
        SmsNotificationDTO that = (SmsNotificationDTO) o;
        return getEventDetailList().equals(that.getEventDetailList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventDetailList());
    }

    @Override
    public String toString() {
        return "SmsNotificationDTO{" +
                "eventDetailList=" + eventDetailList +
                '}';
    }
}
