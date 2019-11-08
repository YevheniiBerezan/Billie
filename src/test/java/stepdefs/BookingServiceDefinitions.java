package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.CreateBookingResponseDto;
import io.restassured.response.Response;
import services.BookingRequestActions;
import utils.LoggerUtils;
import utils.TestSessionController;
import utils.TestSessionVariables;
import utils.TestUtils;

import java.util.logging.Level;

public class BookingServiceDefinitions {

    private Response response;
    private CreateBookingResponseDto bookingResponseDto;
    private BookingRequestActions actions;

    public BookingServiceDefinitions() {
        actions = new BookingRequestActions();
        TestSessionController
                .storeObjectInSession(TestSessionVariables.BOOKING_REQUEST_DTO, TestUtils.generateBookingDto());
    }

    @Given("A POST call with body sent to booking endpoint$")
    public void postWithBodyToBookingService() {
        LoggerUtils.LOGGER.log(Level.INFO, "Calling Booking service with request body");
        final CreateBookingRequestDto bookingRequestDto = TestSessionController
                .getObjectFromSession(TestSessionVariables.BOOKING_REQUEST_DTO, CreateBookingRequestDto.class);
        response = actions.callBookingService(bookingRequestDto);
        TestSessionController.storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, response);
    }

    @Given("A POST call with no body sent to booking endpoint$")
    public void postNoBOdyToBookingService() {
        LoggerUtils.LOGGER.log(Level.INFO, "Calling Booking service with request body");
        response = actions.callBookingService();
        TestSessionController.storeObjectInSession(TestSessionVariables.BOOKING_RESPONSE_DTO, response);
    }

    @When("User updates booking with new data")
    public void updateBookingWithNewInfo() {
        LoggerUtils.LOGGER.log(Level.INFO, "Updating booking with new info");
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


