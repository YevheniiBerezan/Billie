package services;

import dtos.request.booking.BookingDates;
import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.Booking;
import dtos.response.booking.CreateBookingResponseDto;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class RequestVerifications {

    public void verifyBookingStatusCode(final Response response, final int statusCode) {
        Assert.assertThat("Booking status code is not equal to expected on",
                response.getStatusCode(),
                equalTo(statusCode));
    }

    public void verifyNonExitingBookingSearchResponseBody(final Response response) {
        Assert.assertThat("Get non existing booking has returned incorrect value",
                response.getBody().prettyPrint(),
                equalTo("Not Found"));
    }

    public void verifyBookingStatusCode(final Integer responseStatusCode, final int statusCode) {
        Assert.assertThat("Booking status code is not equal to expected on",
                responseStatusCode,
                equalTo(statusCode));
    }

    public void checkBookingIdResponse(final CreateBookingResponseDto bookingResponse) {
        Assert.assertThat("Booking ID is null",
                null,
                is(not(bookingResponse.getBookingId())));
    }

    public void verifyRequestResponseFields(final CreateBookingRequestDto createBookingRequest, final CreateBookingResponseDto bookingResponse) {
        final Booking response = bookingResponse.getBooking();
        final BookingDates requestBookingDates = createBookingRequest.getBookingDates();
        final dtos.response.booking.BookingDates responseBookingDates = bookingResponse.getBooking().getBookingDates();
        assertThat(response.getFirstName())
                .as("'firstname' fields in request is the same as the field in response")
                .isEqualTo(createBookingRequest.getFirstName());
        assertThat(response.getLastName())
                .as("'lastname' fields in request/response should be equal")
                .isEqualTo(createBookingRequest.getLastName());
        assertThat(response.getTotalPrice())
                .as("'totalprice' fields in request/response should be equal")
                .isEqualTo(createBookingRequest.getTotalPrice());
        assertThat(response.getDepositPaid())
                .as("'depositspaid' fields in request/response should be equal")
                .isEqualTo(createBookingRequest.getDepositPaid());
        assertThat(requestBookingDates.getCheckIn())
                .as("'checkin' fields in request/response should be equal")
                .isEqualTo(responseBookingDates.getCheckIn());
        assertThat(requestBookingDates.getCheckOut())
                .as("'checkout' fields in request/response should be equal")
                .isEqualTo(responseBookingDates.getCheckOut());
        assertThat(response.getAdditionalNeeds())
                .as("'additionalneeds' fields in request/response should be equal")
                .isEqualTo(response.getAdditionalNeeds());
    }

    public void verifyRequestsFields(final CreateBookingRequestDto createBookingRequest1, final CreateBookingRequestDto createBookingRequest2) {
        assertThat(createBookingRequest1.getFirstName())
                .as("'firstname' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getFirstName());
        assertThat(createBookingRequest1.getLastName())
                .as("'lastname' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getLastName());
        assertThat(createBookingRequest1.getTotalPrice())
                .as("'totalprice' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getTotalPrice());
        assertThat(createBookingRequest1.getDepositPaid())
                .as("'depositspaid' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getDepositPaid());
        assertThat(createBookingRequest1.getBookingDates().getCheckIn())
                .as("'checkin' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getBookingDates().getCheckIn());
        assertThat(createBookingRequest1.getBookingDates().getCheckOut())
                .as("'checkout' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getBookingDates().getCheckOut());
        assertThat(createBookingRequest1.getAdditionalNeeds())
                .as("'additionalneeds' fields in request/response should be equal")
                .isEqualTo(createBookingRequest2.getAdditionalNeeds());
    }
}
