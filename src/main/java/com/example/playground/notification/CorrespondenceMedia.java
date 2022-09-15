package com.example.playground.notification;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceMedia {

    private String deliveryMode;
    private String operationMode;
}
