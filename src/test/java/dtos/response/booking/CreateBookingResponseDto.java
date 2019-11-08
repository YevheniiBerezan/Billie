package dtos.response.booking;

public class CreateBookingResponseDto {
    private Booking booking;
    private String bookingid;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(final Booking booking) {
        this.booking = booking;
    }

    public String getBookingId() {
        return bookingid;
    }

    public void setBookingId(final String bookingId) {
        this.bookingid = bookingId;
    }

    @Override
    public String toString() {
        return "[booking = " + booking +
                ", bookingid = " + bookingid + "]";
    }
}