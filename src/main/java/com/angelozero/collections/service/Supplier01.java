package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.suplier.Supplier;
import org.springframework.stereotype.Service;

@Service
public class Supplier01 {

    public User execute() {

        Supplier<User> createNewUser = User::new;

        User user = createNewUser.get();

        user.setName("Angelo - Supplier Method Reference in the constructor");

        return user;
    }
}
