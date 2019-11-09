package stepdefs;

import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.CreateBookingResponseDto;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.yecht.Data;
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

    @Then("Update booking/id endpoint returns status code - (\\d+)$")
    public void verifyUpdateBookingIdStatusCode(int statusCode) {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking/id service response code");
        final Integer response = TestSessionController
                .getObjectFromSession(TestSessionVariables.GET_BOOKING_ID_REQUEST_STATUS_CODE, Integer.class);
        verifications.verifyBookingStatusCode(response, statusCode);
    }

    @Then("Get booking/id endpoint returns status code - (\\d+)$")
    public void verifyGetBookingIdStatusCode(int statusCode) {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking/id service response code");
        final Integer response = TestSessionController
                .getObjectFromSession(TestSessionVariables.GET_BOOKING_ID_REQUEST_STATUS_CODE, Integer.class);
        verifications.verifyBookingStatusCode(response, statusCode);
    }

    @Then("Delete booking/id endpoint returns status code - (\\d+)$")
    public void verifyDeleteBookingIdStatusCode(int statusCode) {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking delete booking/id service response code");
        final Integer response = TestSessionController
                .getObjectFromSession(TestSessionVariables.DELETE_BOOKING_REQUEST_STATUS_CODE, Integer.class);
        verifications.verifyBookingStatusCode(response, statusCode);
    }

    @Then("I receive 'Not Found' when searching for non existing booking$")
    public void verifyGetBookingIdStatusCode() {
        LoggerUtils.LOGGER.log(Level.INFO, "Searching for none existing booking");
        final Response response = TestSessionController
                .getObjectFromSession(TestSessionVariables.GET_BOOKING_ID_REQUEST_RESPONSE, Response.class);
        verifications.verifyNonExitingBookingSearchResponseBody(response);
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

    @Then("Get Booking/id service requests fields are not corrupted$")
    public void verifyGetBookingByIdFields() {
        LoggerUtils.LOGGER.log(Level.INFO, "Checking booking requests fields");
        final CreateBookingRequestDto bookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        final CreateBookingRequestDto bookingRequestGetByIdDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.GET_BOOKING_REQUEST_BY_ID_DTO, CreateBookingRequestDto.class);
        verifications.verifyRequestsFields(bookingRequestDto, bookingRequestGetByIdDto);
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
