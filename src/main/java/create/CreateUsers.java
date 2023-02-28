package create;

import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CreateUsers {
    @Step("формируются данные для нового пользователя")
    public static User newUser() {
        return new User(RandomStringUtils.randomAlphanumeric(5, 10),
                RandomStringUtils.randomAlphanumeric(5, 10) + "@back.ru",
                RandomStringUtils.randomAlphanumeric(10));
    }
}
