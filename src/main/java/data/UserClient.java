package data;

import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static data.URL.*;


public class UserClient extends ForUser {

    public ValidatableResponse createUser(User user) {
        return given().log().all().spec(forRQ()).body(user).when().post(CREATE_USER).then();
    }

    public ValidatableResponse loginUser(Authorization authorization) {
        return given().log().all().spec(forRQ()).body(authorization).when().post(LOGIN_USER).then();
    }

    public ValidatableResponse deleteUser(String accessToken) {
        return given().log().all().spec(forRQ()).auth().oauth2(accessToken).when().delete(USER_DATA).then();
    }

}
