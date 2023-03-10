package com.angelozero.collections.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

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

    public User(int i) {
        setPoints(i);
        this.name = "[" + i + "] - Foo";
        this.moderator = false;
    }

    private void setPoints(int points) {
        this.points = points > 0 ? new Random().nextInt(0, points * 2) : 0;
    }

    public void beAdmin() {
        this.moderator = !this.moderator;
    }

}
