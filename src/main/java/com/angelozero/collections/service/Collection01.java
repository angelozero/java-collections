package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Collection01 {

    public List<User> execute() {

        List<User> users = GenerateUserList.execute();

        for (User user : users) {
            System.out.println(user.getName());
        }
        System.out.println("\n");

        return users;
    }
}

