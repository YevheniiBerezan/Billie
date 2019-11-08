package dtos.response.booking;

public class Booking {

    private String firstname;
    private String additionalneeds;
    private BookingDates bookingdates;
    private Integer totalprice;
    private Boolean depositpaid;
    private String lastname;

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(final String firstName) {
        this.firstname = firstName;
    }

    public String getAdditionalNeeds() {
        return additionalneeds;
    }

    public void setAdditionalNeeds(final String additionalNeeds) {
        this.additionalneeds = additionalNeeds;
    }

    public BookingDates getBookingDates() {
        return bookingdates;
    }

    public void setBookingDates(final BookingDates bookingDates) {
        this.bookingdates = bookingDates;
    }

    public Integer getTotalPrice() {
        return totalprice;
    }

    public void setTotalPrice(final Integer totalPrice) {
        this.totalprice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositpaid;
    }

    public void setDepositPaid(final Boolean depositPaid) {
        this.depositpaid = depositPaid;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(final String lastName) {
        this.lastname = lastName;
    }

    @Override
    public String toString() {
        return "[firstname = " + firstname +
                ", additionalneeds = " + additionalneeds +
                ", bookingdates = " + bookingdates +
                ", totalprice = " + totalprice +
                ", depositpaid = " + depositpaid +
                ", lastname = " + lastname + "]";
    }
}