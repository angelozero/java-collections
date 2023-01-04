package com.angelozero.collections.service.consumer;

import com.angelozero.collections.domain.User;

import java.util.function.Consumer;

public class ShowUserName implements Consumer<User> {
    @Override
    public void accept(User user) {
        System.out.println(user.getName());
    }
}
