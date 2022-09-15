package com.example.playground.notification.email;

import lombok.*;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmailNotificationDTO {
    private Set<EventDetail> eventDetailList;
}
