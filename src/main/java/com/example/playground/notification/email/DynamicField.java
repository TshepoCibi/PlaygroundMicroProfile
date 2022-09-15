package com.example.playground.notification.email;


import lombok.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Getter
@Setter

public class DynamicField {
    private String name;
    private String type;
    private String value;

}
