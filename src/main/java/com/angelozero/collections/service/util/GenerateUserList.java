package com.angelozero.collections.service.util;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            users.add(User.builder()
                    .name("[" + i + "] - Foo")
                    .points(getRandomNumber(1, 100))
                    .moderator(false)
                    .build());
        }
        return users;
    }

    private static List<User> generateUsers(boolean isAdmin) {

        boolean moderator = isAdmin || new Random().nextBoolean();

        User user1 = User.builder()
                .name("Jake")
                .randomCode(RandomStringUtils.randomAlphabetic(getRandomNumber(1, 5)))
                .points(getRandomNumber(1, 5))
                .moderator(moderator)
                .build();

        User user2 = User.builder()
                .name("Angelo")
                .randomCode(RandomStringUtils.randomAlphabetic(getRandomNumber(1, 5)))
                .points(getRandomNumber(1, 5))
                .moderator(moderator)
                .build();

        User user3 = User.builder()
                .name("Floki")
                .randomCode(RandomStringUtils.randomAlphabetic(getRandomNumber(1, 5)))
                .points(getRandomNumber(1, 5))
                .moderator(moderator)
                .build();

        return Arrays.asList(user1, user2, user3);
    }

    private static int getRandomNumber(int a, int b) {
        return ThreadLocalRandom.current().nextInt(a, b);
    }
}
