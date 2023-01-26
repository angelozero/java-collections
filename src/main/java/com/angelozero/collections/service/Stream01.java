package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Stream01 {

    public List<User> execute() {

        List<User> users = GenerateUserList.getOneHundredUsers();
        List<User> newUsersList = users.stream().filter(user -> user.getPoints() > 50).collect(Collectors.toList());
        System.out.println("[STREAM_01] - List size: " + newUsersList.size());

        return newUsersList;
    }
}

