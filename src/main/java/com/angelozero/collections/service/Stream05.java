package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Stream05 {

    public List<String> execute() {

        List<User> angelosList = List.of(
                generateUser("Angelo - 1", 10),
                generateUser("Angelo - 2", 15),
                generateUser("Angelo - 3", 20)
        );

        List<User> jakesList = List.of(
                generateUser("Jake - 1", 10),
                generateUser("Jake - 2", 15),
                generateUser("Jake - 3", 20)
        );

        List<User> flokisList = List.of(
                generateUser("Floki - 1", 10),
                generateUser("Floki - 2", 15),
                generateUser("Floki - 3", 20)
        );

        List<List<User>> listOfUsersList = new ArrayList<>();
        listOfUsersList.add(angelosList);
        listOfUsersList.add(jakesList);
        listOfUsersList.add(flokisList);

        return listOfUsersList.stream().flatMap(Collection::stream).map(User::getName).collect(Collectors.toList());
    }


    private User generateUser(String name, int points) {
        return User.builder().name(name).points(points).build();
    }
}

