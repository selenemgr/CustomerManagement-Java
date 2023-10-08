package customerinfo;

public class Customer {
    // Customer Properties
    int id;
    String name;
    int contactNumber;
    String email;
    Address address;

    // Customer Parameterized Constructor - Default Address
    public Customer(int id, String name, int contactNumber, String email) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;

        this.address = new Address();
    }
    // Customer Parameterized Constructor - Custom Address
    public Customer(int id, String name, int contactNumber, String email, Address address) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
        this.address = address;
    }
}
