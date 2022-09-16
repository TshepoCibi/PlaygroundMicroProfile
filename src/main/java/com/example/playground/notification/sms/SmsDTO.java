package com.example.playground.notification.sms;

import lombok.*;

@Getter
@Setter
public class SmsDTO {
    String mobileNumber;
    String reference;
    String correlationId;
    String country;
    String message;
}
