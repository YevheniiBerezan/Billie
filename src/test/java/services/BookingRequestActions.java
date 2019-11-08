package services;

import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.CreateBookingResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.JsonUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;
import utils.TestUtils;

import static io.restassured.RestAssured.given;

public class BookingRequestActions {

    private static String BOOKING_URL = "https://restful-booker.herokuapp.com/booking";

    public CreateBookingResponseDto createBooking(final CreateBookingRequestDto bookingDto) {
        final CreateBookingResponseDto response = callBookingService(bookingDto)
                .then()
                .extract()
                .as(CreateBookingResponseDto.class);
        TestSessionController.storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, response);
        return response;
    }

    public Response callBookingService(final CreateBookingRequestDto bookingDto) {
        final String bookingJSON = JsonUtils.createJson(bookingDto);
        final Response response = given()
                .body(bookingJSON)
                .contentType(ContentType.JSON)
                .post(BOOKING_URL);
        TestSessionController.storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, response);
        return response;
    }

//    public Response updateBooking() {
//        final CreateBookingResponseDto oldBookingDto = TestSessionController
//                .getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE_DTO, CreateBookingResponseDto.class);
//        final CreateBookingRequestDto newBookingDto = TestUtils.generateBookingDto();
//        TestSessionController.storeObjectInSession(TestSessionVariables.UPDATED_BOOKING_REQUEST_DTO, newBookingDto);
//        given()
//                .baseUri(BOOKING_URL + oldBookingDto.getBookingId())
//                .body()
//    }

    public Response callBookingService() {
        return given()
                .contentType(ContentType.JSON)
                .post(BOOKING_URL);
    }
}
