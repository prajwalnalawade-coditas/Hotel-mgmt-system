package Hotel_mgmt_sys;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customerData = new ArrayList<>();
    static ArrayList<HotelRoom> roomData = new ArrayList<>();
    static ArrayList<Booking> bookingData = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        roomData.add(new BasicRoom(001));
        roomData.add(new PremiumRoom(002));
        roomData.add(new LuxuryRoom(003));
        while (true) {

            System.out.println("1. register customer");
            System.out.println("2. view customers");
            System.out.println("3. make reservation");
            System.out.println("4. view rooms");
            System.out.println("5. cancel reservation");
            System.out.println("6. exit");
            int choice = input.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("enter Customer ID: ");
                        int cid = input.nextInt();
                        input.nextLine();
                        for (Customer c : customerData) {
                            if (c.getCustomerId() == cid)
                                throw new InvalidUserException("Customer ID already exists!");}
                        System.out.print("enter Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter Phone: ");
                        String phone = input.nextLine();
                        customerData.add(new Customer(cid, name, phone));
                        System.out.println("Customer registered successfully.");
                        break;
                    case 2:
                        if (customerData.isEmpty()) {
                            System.out.println("No customers found.");
                        } else {
                            for (Customer c : customerData)
                                System.out.println(c);}
                        break;
                    case 3:
                        System.out.print("Enter Booking ID: ");
                        int bid = input.nextInt();
                        for (Booking b : bookingData) {
                            if (b.getBookingId() == bid)
                                throw new BookingException("Booking ID already used!");
                        }
                        System.out.print("Enter Customer ID: ");
                        int custId = input.nextInt();
                        boolean exists = false;
                        for (Customer c : customerData) {
                            if (c.getCustomerId() == custId)
                                exists = true;
                        }
                        if (!exists)
                            throw new UserNotFoundException("Customer does not exist!");
                        input.nextLine();
                        System.out.print("Enter Date (DD/MM/YYYY): ");
                        String date = input.nextLine();
                        if (date.length() < 8)
                            throw new BookingException("Invalid date format!");
                        System.out.println("1. Room  2. Event Hall  3. Spa");
                        int type = input.nextInt();

                        if (type == 1) {
                            System.out.print("Enter Room Number: ");
                            int rno = input.nextInt();
                            HotelRoom selected = null;
                            for (HotelRoom r : roomData) {
                                if (r.getNumber() == rno)
                                    selected = r;
                            }
                            if (selected == null)
                                throw new NoRoomException("Room not found!");
                            if (!selected.isFree())
                                throw new BookingException("Room already booked!");
                            selected.reserve();
                            bookingData.add(
                                    new RoomBooking(bid, custId, date, rno)
                            );
                            System.out.println("Room reserved successfully.");
                        }
                        else if (type == 2) {
                            bookingData.add(
                                    new HallBooking(bid, custId, date)
                            );
                            System.out.println("Event hall reservation completed.");
                        }
                        else if (type == 3) {
                            bookingData.add(
                                    new SpaBooking(bid, custId, date)
                            );
                            System.out.println("Spa reservation completed.");
                        }
                        break;
                    case 4:
                        for (HotelRoom r : roomData) {
                            System.out.println("Room: " + r.getNumber() +" Available: " + r.isFree());
                        }
                        break;
                    case 5:
                        System.out.print("Enter Booking ID to cancel: ");
                        int removeId = input.nextInt();
                        Booking removeObj = null;
                        for (Booking b : bookingData) {
                            if (b.getBookingId() == removeId)
                                removeObj = b;
                        }
                        if (removeObj != null) {
                            bookingData.remove(removeObj);
                            System.out.println("Reservation cancelled successfully.");
                        } else {
                            System.out.println("Booking ID not found.");
                        }
                        break;
                    case 6:
                        System.out.println("System shutting down...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option selected.");
                }
            } catch (Exception e) {
                System.out.println("Error: "+ e.getMessage());
            }
        }
    }
}