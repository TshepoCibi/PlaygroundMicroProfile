package com.example.playground.notification;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CorrespondenceAddressee {

    private String mobileContactType;
    private String mobileContactValue;
}
