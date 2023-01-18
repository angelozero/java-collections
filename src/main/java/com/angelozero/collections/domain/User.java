package com.angelozero.collections.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String name;
    private String randomCode;
    private int points;
    private boolean moderator;

    public void beAdmin() {
        this.moderator = !this.moderator;
    }
}
