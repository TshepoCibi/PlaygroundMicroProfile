package com.example.playground.notification;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceContent {

    private String alertText;
    private String customerId;
}
