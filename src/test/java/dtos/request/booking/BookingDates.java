package dtos.request.booking;

public class BookingDates {
    private String checkin;
    private String checkout;

    public String getCheckIn() {
        return checkin;
    }

    public void setCheckIn(final String checkIn) {
        this.checkin = checkIn;
    }

    public String getCheckOut() {
        return checkout;
    }

    public void setCheckout(final String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "[checkin = " + checkin +
                ", checkout = " + checkout + "]";
    }
}