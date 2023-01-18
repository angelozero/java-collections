package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;
import java.util.function.Function;

@Service
public class Supplier03 {

    public User execute() {

        BiFunction<String, Integer, User> createNewUser = User::new;

        return createNewUser.apply("Angelo - Supplier Bi Function", 10);

    }
}
