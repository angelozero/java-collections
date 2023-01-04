package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@AllArgsConstructor
public class Lambda02 {

    public List<User> execute() {

        List<User> users = new ArrayList<>(GenerateUserList.execute());

        /**
         *         Predicate<User> predicate = new Predicate<User>() {
         *             @Override
         *             public boolean test(User user) {
         *                 return user.getPoints() < 10;
         *             }
         *         };
         *
         *         users.removeIf(predicate);
         */

        users.removeIf(user -> user.getPoints() <= 2);

        return users;
    }
}

