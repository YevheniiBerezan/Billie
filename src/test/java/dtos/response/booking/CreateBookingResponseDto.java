package dtos.response.booking;

public class CreateBookingResponseDto {
    private Booking booking;
    private int bookingid;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(final Booking booking) {
        this.booking = booking;
    }

    public int getBookingId() {
        return bookingid;
    }

    public void setBookingId(final int bookingId) {
        this.bookingid = bookingId;
    }

    @Override
    public String toString() {
        return "[booking = " + booking +
                ", bookingid = " + bookingid + "]";
    }
}