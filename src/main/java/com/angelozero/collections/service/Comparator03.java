package com.angelozero.collections.service;

import com.angelozero.collections.domain.User;
import com.angelozero.collections.service.util.GenerateUserList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class Comparator03 {

    public List<String> execute() {

        List<String> usersNames = new ArrayList<>(GenerateUserList.execute().stream().map(User::getName).toList());

        usersNames.sort(Comparator.naturalOrder());

        return usersNames;

    }
}
