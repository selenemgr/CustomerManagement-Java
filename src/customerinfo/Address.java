package customerinfo;

public class Address {
    // Address Properties
    private int houseNumber;
    private String streetName;
    private String city;
    private String province;
    private String country;
    private String postalCode;

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

    // Address Getter & Setter
    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
