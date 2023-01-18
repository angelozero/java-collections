package com.angelozero.collections.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String randomCode;
    private int points;
    private boolean moderator;

    public User(String name) {
        this.name = name;
    }

    public User(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public void beAdmin() {
        this.moderator = !this.moderator;
    }
}
