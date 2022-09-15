package com.example.playground.notification;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceTemplateReference {

    private String smsDestinationType;
    private String smsEventId;
}
