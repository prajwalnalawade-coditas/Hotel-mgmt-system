package Hotel_mgmt_sys;
public class HotelRoom {
    protected int number;
    protected boolean free = true;
    public HotelRoom(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public boolean isFree() {
        return free;
    }
    public void reserve() {
        free = false;
    }
    public void vacate() {
        free = true;
    }
}
class BasicRoom extends HotelRoom {
    public BasicRoom(int number) {
        super(number);
    }
}
class PremiumRoom extends HotelRoom {
    public PremiumRoom(int number) {
        super(number);
    }
}
class LuxuryRoom extends HotelRoom {
    public LuxuryRoom(int number) {
        super(number);
    }
}