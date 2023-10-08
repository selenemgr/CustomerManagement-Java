package customerinfo;

public class Address {
    // Address Properties
    int houseNumber;
    String streetName;
    String city;
    String province;
    String country;
    String postalCode;

    // Address Default Constructor
    public Address() {
        this(0, "N/A", "N/A", "N/A", "N/A", "N/A");
    }

    // Address Parameterized Constructor
    public Address(int houseNumber, String streetName, String city, String province, String country, String postalCode) {
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.country = country;
        this.postalCode = postalCode;
    }
}
