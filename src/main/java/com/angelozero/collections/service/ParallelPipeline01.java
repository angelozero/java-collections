package com.angelozero.collections.service;


import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ParallelPipeline01 {

    /**
     * Filter users with more out of 100 points,
     * order them and collect the result in a list
     */
    public List<User> execute() {

        List<User> users = GenerateUserList.getOneHundredUsers();

        return users.parallelStream()
                .filter(u -> u.getPoints() > 100)
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }
}
