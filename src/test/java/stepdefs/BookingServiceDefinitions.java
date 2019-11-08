package stepdefs;

import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.CreateBookingResponseDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import services.BookingRequestActions;
import utils.LoggerUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;

import java.util.logging.Level;

public class BookingServiceDefinitions {

    private BookingRequestActions actions;

    public BookingServiceDefinitions() {
        actions = new BookingRequestActions();
    }

    @Given("A POST call with body sent to booking endpoint$")
    public void postWithBodyToBookingService() {
        LoggerUtils.LOGGER.log(Level.INFO, "Calling Booking service with request body");
        actions.createBooking();
    }

    @When("Initial booking id is saved")
    public void saveBookingIdToSession() {
        LoggerUtils.LOGGER.log(Level.INFO, "Saving initial booking id into session");
        final CreateBookingResponseDto responseDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_RESPONSE_DTO, CreateBookingResponseDto.class);
        TestSessionController.storeObjectInSession(TestSessionVariables.INITIAL_BOOKING_ID, responseDto.getBookingId());
    }

    @When("We amend the booking with new details")
    public void updateBookingWithNewInfo() {
        LoggerUtils.LOGGER.log(Level.INFO, "Updating booking with new info");
        actions.updateBooking();
    }
}


