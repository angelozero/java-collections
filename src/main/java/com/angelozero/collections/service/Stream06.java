package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Stream06 {

    public List<User> execute() {

        User angelo = generateUser("Angelo", 10);
        User jake = generateUser("Jake", 10);
        User floki = generateUser("Floki", 10);

        List<User> angelosList = List.of(angelo, angelo, angelo);
        List<User> jakesList = List.of(jake, jake, jake);
        List<User> flokisList = List.of(floki, floki, floki);

        List<List<User>> listOfUsersList = new ArrayList<>();
        listOfUsersList.add(angelosList);
        listOfUsersList.add(jakesList);
        listOfUsersList.add(flokisList);

        return listOfUsersList.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
    }


    private User generateUser(String name, int points) {
        return User.builder().name(name).points(points).build();
    }
}

