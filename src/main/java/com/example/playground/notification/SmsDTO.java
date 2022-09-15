package com.example.playground.notification;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SmsDTO {
    String mobileNumber;
    String reference;
    String correlationId;
    String country;
    String message;
}
