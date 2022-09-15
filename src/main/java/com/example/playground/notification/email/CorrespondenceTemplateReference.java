package com.example.playground.notification.email;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceTemplateReference {
    private String emailDestinationType;
    private String emailEventId;
}
