package com.example.playground.notification.email;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceMedia {
    private String deliveryMode;
}
