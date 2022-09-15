package com.example.playground.notification.email;

import lombok.*;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class EmailDTO {
    String email;
    String reference;
    String correlationId;
    String country;
    Set<Attachment>  attachments;
    String applicantName;
}
