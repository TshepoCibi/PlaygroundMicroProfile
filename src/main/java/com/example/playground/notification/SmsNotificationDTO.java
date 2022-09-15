package com.example.playground.notification;

import lombok.*;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SmsNotificationDTO {

    private Set<EventDetail> eventDetailList;
}
