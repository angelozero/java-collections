package com.angelozero.collections.service.util;

import com.angelozero.collections.domain.User;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@AllArgsConstructor
public class GenerateUserList {

    public static List<User> execute() {
        User user1 = User.builder()
                .name("Jake")
                .randomCode(RandomStringUtils.randomAlphabetic(getRandomNumber()))
                .points(getRandomNumber())
                .build();

        User user2 = User.builder()
                .name("Angelo")
                .randomCode(RandomStringUtils.randomAlphabetic(getRandomNumber()))
                .points(getRandomNumber())
                .build();

        User user3 = User.builder()
                .name("Floki")
                .randomCode(RandomStringUtils.randomAlphabetic(getRandomNumber()))
                .points(getRandomNumber())
                .build();

        return Arrays.asList(user1, user2, user3);
    }

    private static int getRandomNumber() {
        return ThreadLocalRandom.current().nextInt(1, 5);
    }
}
