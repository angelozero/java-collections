package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class Comparator01 {

    public List<User> execute() {

        List<User> users = GenerateUserList.execute();

//        Comparator<User> comparator = new Comparator<User>() {
//            @Override
//            public int compare(User userA, User userB) {
//                return userA.getName().compareTo(userB.getName());
//            }
//        };

//        Comparator<User> comparator =
//                (userA, userB) -> userA.getName().compareTo(userB.getName());

//        Collections.sort(users, comparator);


//        Collections.sort(users, (userA, userB) -> userA.getName().compareTo(userB.getName()));

        users.sort(Comparator.comparing(User::getName));

        return users;

    }
}
