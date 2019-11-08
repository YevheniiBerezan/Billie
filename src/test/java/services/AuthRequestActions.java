package services;

import dtos.request.auth.AuthTokenRequestDto;
import dtos.response.auth.AuthToken;
import io.restassured.http.ContentType;
import utils.JsonUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;

import static io.restassured.RestAssured.given;

public class AuthRequestActions {

    private final String AUTH_TOKEN_URL = "https://restful-booker.herokuapp.com/auth";

    public AuthToken callBookingService() {
        final String authTokenJson = JsonUtils.createJson(new AuthTokenRequestDto());
        final AuthToken token = given()
                .body(authTokenJson)
                .contentType(ContentType.JSON)
                .post(AUTH_TOKEN_URL)
                .as(AuthToken.class);
        TestSessionController.storeObjectInSession(TestSessionVariables.AUTH_TOKEN_DTO, token);
        return token;
    }
}
