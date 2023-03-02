package com.angelozero.collections.service.util;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class GenerateUserList {

    public static List<User> execute() {
        return generateUsers(false);
    }

    public static List<User> execute(boolean isAdmin) {
        return generateUsers(isAdmin);
    }

    public static List<User> getOneHundredUsers() {

        return IntStream.range(0, 100)
                .mapToObj(User::new)
                .collect(Collectors.toList());
    }

    private static List<User> generateUsers(boolean isAdmin) {

        boolean moderator = isAdmin || new Random().nextBoolean();

        User user1 = User.builder()
                .name("Jake")
                .randomCode(RandomStringUtils.randomAlphabetic(new Random().nextInt(0, 5)))
                .points(new Random().nextInt(0, 100))
                .moderator(moderator)
                .build();

        User user2 = User.builder()
                .name("Angelo")
                .randomCode(RandomStringUtils.randomAlphabetic(new Random().nextInt(0, 5)))
                .points(new Random().nextInt(0, 5))
                .moderator(moderator)
                .build();

        User user3 = User.builder()
                .name("Floki")
                .randomCode(RandomStringUtils.randomAlphabetic(new Random().nextInt(0, 5)))
                .points(new Random().nextInt(0, 5))
                .moderator(moderator)
                .build();

        return Arrays.asList(user1, user2, user3);
    }


}
