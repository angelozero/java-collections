package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Stream04 {

    public int execute() {

        List<User> users = GenerateUserList.getOneHundredUsers();
        return users.stream().mapToInt(User::getPoints).reduce(1, (a, b) -> a * b);
    }
}

