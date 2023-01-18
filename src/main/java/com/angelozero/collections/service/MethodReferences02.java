package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class MethodReferences02 {

    public List<User> execute() {

        List<User> users = new ArrayList<>(GenerateUserList.execute());

        users.addAll(Arrays.asList(
                null,
                null,
                null));

        users.sort(
                Comparator.nullsLast(
                        Comparator.comparing(User::getPoints)
                                .thenComparing(User::getName))
        );

        return users;
    }
}
