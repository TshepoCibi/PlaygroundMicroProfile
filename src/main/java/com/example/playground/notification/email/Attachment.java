package com.example.playground.notification.email;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Attachment {
    private String name;
    private String type;
    private String data;
}
