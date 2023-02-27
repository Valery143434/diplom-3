package requests;

import create.User;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import login.Authorization;
import url.ForRequest;

import static io.restassured.RestAssured.given;
import static url.URL.*;


public class sendsRequests extends ForRequest {

    @Step("отправляется запрос на создание пользователя")
    public ValidatableResponse createUserRequest(User user) {
        return given().log().all().spec(forRQ()).body(user).when().post(CREATE_USER).then();
    }

    @Step("отправляется запрос на авторизацию созданного пользователя")
    public ValidatableResponse loginUserRequest(Authorization authorization) {
        return given().log().all().spec(forRQ()).body(authorization).when().post(LOGIN_USER).then();
    }

    @Step("отправляется запрос на удаление созданного пользователя")
    public ValidatableResponse deleteUserRequest(String accessToken) {
        return given().log().all().spec(forRQ()).auth().oauth2(accessToken).when().delete(USER_DATA).then();
    }

}
