package utils;

import dtos.request.booking.BookingDates;
import dtos.request.booking.CreateBookingRequestDto;
import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestUtils {

    private static String getFirstName() {
        return "Test first name " + RandomUtils.nextInt(0, 10000);
    }

    private static String getLastName() {
        return "Test last name " + RandomUtils.nextInt(0, 10000);
    }

    private static int getTotalPrice() {
        return RandomUtils.nextInt(0, 100);
    }

    private static boolean depositPaid() {
        return Math.random() < 0.5;
    }

    private static String getCheckInDate() {
        return createRandomDate().toString();
    }

    private static String getCheckOutDate() {
        return createRandomDate().toString();
    }

    private static String getAdditionalServices() {
        int index = new Random().nextInt(listOfAdditionalServices().size());
        return listOfAdditionalServices().get(index);
    }

    private static int createRandomIntBetween(final int start, final int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static List<String> listOfAdditionalServices() {
        final List<String> listOfAdditionalServices = new ArrayList<>();
        listOfAdditionalServices.add("Disabled room");
        listOfAdditionalServices.add("Smoking rooms");
        listOfAdditionalServices.add("Low floor room");
        listOfAdditionalServices.add("High floor room");
        listOfAdditionalServices.add("Queen bad room");

        return listOfAdditionalServices;
    }

    private static LocalDate createRandomDate() {
        int day = createRandomIntBetween(10, 28);
        int month = createRandomIntBetween(5, 12);
        int year = createRandomIntBetween(2019, 2019);
        return LocalDate.of(year, month, day);
    }

    public static CreateBookingRequestDto generateBookingDto() {
        final CreateBookingRequestDto bookingRequestDto = new CreateBookingRequestDto();
        final BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckIn(TestUtils.getCheckInDate());
        bookingDates.setCheckout(TestUtils.getCheckOutDate());
        bookingRequestDto.setFirstName(TestUtils.getFirstName());
        bookingRequestDto.setLastName(TestUtils.getLastName());
        bookingRequestDto.setTotalPrice(TestUtils.getTotalPrice());
        bookingRequestDto.setDepositPaid(TestUtils.depositPaid());
        bookingRequestDto.setBookingDates(bookingDates);
        bookingRequestDto.setAdditionalNeeds(TestUtils.getAdditionalServices());
        return bookingRequestDto;
    }
}
