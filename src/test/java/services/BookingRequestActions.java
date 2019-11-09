package services;

import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.auth.AuthToken;
import dtos.response.booking.CreateBookingResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.JsonUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;
import utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookingRequestActions {

    private static String BOOKING_URL = "https://restful-booker.herokuapp.com/booking/";

    public BookingRequestActions() {
        TestSessionController
                .storeObjectInSession(TestSessionVariables.BOOKING_REQUEST_DTO, TestUtils.generateBookingDto());
        new AuthRequestActions().createAuthToken();
    }

    public void createBooking() {
        final CreateBookingRequestDto bookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        final String bookingJSON = JsonUtils.createJson(bookingRequestDto);
        final Response response = given()
                .body(bookingJSON)
                .contentType(ContentType.JSON)
                .post(BOOKING_URL);
        TestSessionController
                .storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE, response);
        TestSessionController
                .storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, response.as(CreateBookingResponseDto.class));
    }

    public void getBookingServiceById() {
        final int bookingId = TestSessionController.getObjectFromSession(TestSessionVariables.INITIAL_BOOKING_ID, Integer.class);

        final Response response = given()
                .get(BOOKING_URL + bookingId);

        if (response.statusCode() == 200) {
            TestSessionController.storeObjectInSession(TestSessionVariables.GET_BOOKING_REQUEST_BY_ID_DTO, response.as(CreateBookingRequestDto.class));
        }
        TestSessionController.storeObjectInSession(TestSessionVariables.GET_BOOKING_ID_REQUEST_STATUS_CODE, response.statusCode());
        TestSessionController.storeObjectInSession(TestSessionVariables.GET_BOOKING_ID_REQUEST_RESPONSE, response);
    }

    public void deleteBookingById() {
        final AuthToken authToken = TestSessionController.getObjectFromSession(TestSessionVariables.AUTH_TOKEN_DTO, AuthToken.class);
        final int bookingId = TestSessionController.getObjectFromSession(TestSessionVariables.INITIAL_BOOKING_ID, Integer.class);

        final Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + authToken.getToken())
                .when()
                .delete(BOOKING_URL + bookingId);

        TestSessionController.storeObjectInSession(TestSessionVariables.DELETE_BOOKING_REQUEST_STATUS_CODE, response.statusCode());
    }

    public void updateBooking() {
        final AuthToken authToken = TestSessionController.getObjectFromSession(TestSessionVariables.AUTH_TOKEN_DTO, AuthToken.class);

        final Map<String, String> headers = new HashMap<>();
        headers.put("Cookie", "token=" + authToken.getToken());
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json");

        final CreateBookingResponseDto oldBookingResponseDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE_DTO, CreateBookingResponseDto.class);
        final CreateBookingRequestDto newBookingDto = TestUtils.generateBookingDto();
        TestSessionController.storeObjectInSession(TestSessionVariables.NEW_BOOKING_REQUEST_DTO, newBookingDto);
        final String newBookingJson = JsonUtils.createJson(newBookingDto);

        final Response newBookingRequest = given()
                .headers(headers)
                .body(newBookingJson)
                .when()
                .put(BOOKING_URL + oldBookingResponseDto.getBookingId());

        TestSessionController.storeObjectInSession(TestSessionVariables.GET_BOOKING_ID_REQUEST_STATUS_CODE, newBookingRequest.statusCode());
        TestSessionController.storeObjectInSession(TestSessionVariables.UPDATED_BOOKING_REQUEST_DTO, newBookingRequest.getBody().as(CreateBookingRequestDto.class));
    }
}
