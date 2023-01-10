package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.consumer.ShowUserName;
import com.angelozero.collections.service.util.GenerateUserList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@AllArgsConstructor
public class Collection02 {

    public List<User> execute() {

        List<User> users = GenerateUserList.execute();

        // 01
        ShowUserName showUserName = new ShowUserName();
        users.forEach(showUserName);
        System.out.println("\n");

        // 02
        users.forEach(new Consumer<User>() {
            public void accept(User u) {
                System.out.println(u.getName());
            }
        });
        System.out.println("\n");

        // 03
        Consumer<User> showName3 =
                (User u) -> {
                    System.out.println(u.getName());
                };
        users.forEach(showName3);
        System.out.println("\n");

        // 04
        Consumer<User> showName4 = u -> System.out.println(u.getName());
        users.forEach(showName4);
        System.out.println("\n");

        // 05
        users.forEach(u -> System.out.println(u.getName()));
        System.out.println("\n");

        return users;

    }
}
