package services;

import dtos.request.booking.BookingDates;
import dtos.request.booking.CreateBookingRequestDto;
import dtos.response.booking.Booking;
import dtos.response.booking.CreateBookingResponseDto;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.*;

public class RequestVerifications {

    public void verifyBookingStatusCode(final Response response, final int statusCode) {
        Assert.assertThat("Booking status code is not equal to expected on", response.getStatusCode(), equalTo(statusCode));
    }

    public void checkBookingIdResponse(final CreateBookingResponseDto bookingResponse) {
        Assert.assertThat("Booking ID is null", null, is(not(bookingResponse.getBookingId())));
    }

    public void verifyRequestResponseFields(final CreateBookingRequestDto createBookingRequest, final CreateBookingResponseDto bookingResponse) {
        final Booking response = bookingResponse.getBooking();
        final BookingDates requestBookingDates = createBookingRequest.getBookingDates();
        final dtos.response.booking.BookingDates responseBookingDates = bookingResponse.getBooking().getBookingDates();
        Assert.assertThat("'firstname' field in request/response is not correct ", response.getFirstName(),
                equalTo(createBookingRequest.getFirstName()));
        Assert.assertThat("'lastname' field in request/response is not correct ", response.getLastName(),
                equalTo(createBookingRequest.getLastName()));
        Assert.assertThat("'totalprice' field in request/response is not correct ", response.getTotalPrice(),
                equalTo(createBookingRequest.getTotalPrice()));
        Assert.assertThat("'depositspaid' field in request/response is not correct ", response.getDepositPaid(),
                equalTo(createBookingRequest.getDepositPaid()));
        Assert.assertThat("'checkin' field in request/response is not correct ", requestBookingDates.getCheckIn(),
                equalTo(responseBookingDates.getCheckIn()));
        Assert.assertThat("'checkout' field in request/response is not correct ", requestBookingDates.getCheckout(),
                equalTo(responseBookingDates.getCheckOut()));
        Assert.assertThat("'additionalneeds' field in request/response is not correct ", response.getAdditionalNeeds(),
                equalTo(response.getAdditionalNeeds()));
    }
}
