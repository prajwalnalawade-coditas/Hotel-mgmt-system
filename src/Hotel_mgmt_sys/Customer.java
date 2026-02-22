package Hotel_mgmt_sys;
public class Customer {
    private int customerId;
    private String customerName;
    private String phone;
    public Customer(int customerId, String customerName, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phone = phone;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String toString() {
        return "Customer ID: " + customerId +
                " Name: " + customerName +
                " Phone: " + phone;
    }
}