package stepdefs;

import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.CreateBookingResponseDto;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import services.RequestVerifications;
import utils.LoggerUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;

import java.util.logging.Level;

public class BookingServiceAsserts {

    private RequestVerifications verifications;

    public BookingServiceAsserts() {
        verifications = new RequestVerifications();
    }

    @Then("Booking endpoint returns status code - (\\d+)$")
    public void verifyBookingStatusCode(int statusCode) {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking service response code");
        final Response response = TestSessionController.getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE, Response.class);
        verifications.verifyBookingStatusCode(response, statusCode);
    }

    @Then("Booking/id endpoint returns status code - (\\d+)$")
    public void verifyBookingIdStatusCode(int statusCode) {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking/id service response code");
        final Integer response = TestSessionController
                .getObjectFromSession(TestSessionVariables.NEW_BOOKING_REQUEST_STATUS_CODE, Integer.class);
        verifications.verifyBookingStatusCode(response, statusCode);
    }

    @Then("Booking service request / response fields are not corrupted$")
    public void verifyBookingFields() {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking request / response fields");
        final CreateBookingRequestDto bookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        final CreateBookingResponseDto bookingResponseDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE_DTO, CreateBookingResponseDto.class);
        verifications.verifyRequestResponseFields(bookingRequestDto, bookingResponseDto);
    }

    @Then("Updated booking service request fields are correct$")
    public void verifyUpdatedBookingFields() {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking updated booking request / response fields");
        final CreateBookingRequestDto updatedBookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.UPDATED_BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        final CreateBookingRequestDto updatedBookingResponseDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.NEW_BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        verifications.verifyRequestsFields(updatedBookingRequestDto, updatedBookingResponseDto);
    }

    @Then("Booking service response booking ID field has value$")
    public void bookingIdIsNotNull() {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking if booking id field has value");
        final CreateBookingResponseDto bookingResponse = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE_DTO, CreateBookingResponseDto.class);
        verifications.checkBookingIdResponse(bookingResponse);
    }
}
