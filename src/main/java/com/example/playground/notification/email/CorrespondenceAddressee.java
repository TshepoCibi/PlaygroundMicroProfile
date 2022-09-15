package com.example.playground.notification.email;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceAddressee {
    private String emailContactType;
    private String emailContactValue;
}
