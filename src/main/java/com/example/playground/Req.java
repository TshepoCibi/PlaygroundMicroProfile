package com.example.playground;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Req {
    private String name;

    @Override
    public String toString() {
        return "Req{" +
                "name='" + name + '\'' +
                '}';
    }
}
