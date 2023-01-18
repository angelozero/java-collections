package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.suplier.Supplier;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class Supplier02 {

    public User execute() {

        Function<String, User> createNewUser = User::new;

        return createNewUser.apply("Angelo - Supplier Method Reference in the constructor parameter");

    }
}
