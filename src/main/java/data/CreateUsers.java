package data;

import org.apache.commons.lang3.RandomStringUtils;

public class CreateUsers {
    public static User newUser() {
        return new User(RandomStringUtils.randomAlphanumeric(10),
                RandomStringUtils.randomAlphanumeric(10) + "@back.ru",
                RandomStringUtils.randomAlphanumeric(10));
    }
}
