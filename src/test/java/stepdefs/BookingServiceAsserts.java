package stepdefs;

import cucumber.api.java.en.Then;
import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.CreateBookingResponseDto;
import io.restassured.response.Response;
import services.BookingRequestActions;
import services.RequestVerifications;
import utils.LoggerUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;

import java.util.logging.Level;

public class BookingServiceAsserts {

    private CreateBookingResponseDto bookingResponseDto;
    private BookingRequestActions actions;
    private RequestVerifications verifications;

    public BookingServiceAsserts() {
        actions = new BookingRequestActions();
        verifications = new RequestVerifications();
    }

    @Then("Booking endpoint returns status code - (\\d+)$")
    public void verifyStatusCode(int statusCode) {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking service response code");
        final Response response = TestSessionController.getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE_DTO, Response.class);
        verifications.verifyBookingStatusCode(response, statusCode);
    }

    @Then("Booking service request / response fields are not corrupted$")
    public void verifyBookingFields() {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking request / response fields");
        final CreateBookingRequestDto bookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        bookingResponseDto = actions.createBooking(bookingRequestDto);
        verifications.verifyRequestResponseFields(bookingRequestDto, bookingResponseDto);
        TestSessionController.storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, bookingResponseDto);
    }

    @Then("Booking service response booking ID field has value$")
    public void bookingIdIsNotNull() {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking if booking id field has value");
        final CreateBookingRequestDto bookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        bookingResponseDto = actions.createBooking(bookingRequestDto);
        verifications.checkBookingIdResponse(bookingResponseDto);
        TestSessionController.storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, bookingResponseDto);
    }

//    @And("response includes the following in any order")
//    public void response_contains_in_any_order(Map<String, String> responseFields) {
//        for (Map.Entry<String, String> field : responseFields.entrySet()) {
//            if (StringUtils.isNumeric(field.getValue())) {
//                json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
//            } else {
//                json.body(field.getKey(), containsInAnyOrder(field.getValue()));
//            }
//        }
//    }
}


