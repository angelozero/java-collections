package com.angelozero.collections.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private String name;
    private int points;
    private boolean moderator;
}
