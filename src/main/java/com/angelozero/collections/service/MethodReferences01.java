package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MethodReferences01 {

    public List<User> execute(boolean isAdmin) {

        List<User> users = new ArrayList<>(GenerateUserList.execute(isAdmin));

        users.forEach(User::beAdmin);

        return users;
    }
}
