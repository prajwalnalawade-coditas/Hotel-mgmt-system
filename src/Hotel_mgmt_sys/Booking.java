package Hotel_mgmt_sys;

public abstract class Booking {
    protected int bookingId;
    protected int customerId;
    protected String bookingDate;
    public Booking(int bookingId, int customerId, String bookingDate) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.bookingDate = bookingDate;
    }
    public int getBookingId() {
        return bookingId;
    }
    public abstract void display();
}
class RoomBooking extends Booking {
    private int roomNo;
    public RoomBooking(int bookingId, int customerId,
                       String bookingDate, int roomNo) {
        super(bookingId, customerId, bookingDate);
        this.roomNo = roomNo;
    }
    public void display() {
        System.out.println("Room Booking ID: " + bookingId +
                " Customer: " + customerId +
                " Room: " + roomNo +
                " Date: " + bookingDate);
    }
}
class HallBooking extends Booking {
    public HallBooking(int bookingId, int customerId, String bookingDate) {
        super(bookingId, customerId, bookingDate);
    }
    public void display() {
        System.out.println("Event Hall booked on " + bookingDate +
                " by Customer " + customerId);
    }
}
class SpaBooking extends Booking {
    public SpaBooking(int bookingId, int customerId, String bookingDate) {
        super(bookingId, customerId, bookingDate);
    }
    public void display() {
        System.out.println("Spa session reserved on " + bookingDate +
                " by Customer " + customerId);
    }
}