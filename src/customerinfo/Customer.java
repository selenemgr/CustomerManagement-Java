package customerinfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    // Customer Properties
    private int id;
    private String name;
    private int contactNumber;
    private String email;
    private Address address;
    private List<Address> addressList;

    private static Scanner scanner = new Scanner(System.in);

    // Customer Default Constructor
    public Customer() {
    }

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

    // Customer Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    // Customer Methods

    // Method to Create a New Customer with User Inputs and Default Address
    public static Customer newCustomerDefaultAddress(){
        System.out.println("\n--------------------------------");
        System.out.println("         Customer Creation           ");
        System.out.println("--------------------------------");
        System.out.println("* Notes: \n- Leave a Space After a Comma");
        System.out.println("- Assign Values in Format Order");
        System.out.println("- Type 'Exit' to Go Back to Main Menu");
        System.out.println("--------------------------------\n");
        System.out.print("Enter Customer Values (ID, Name, Contact Number, Email ID: ");

        String userInput = scanner.nextLine();

        if (userInput.toLowerCase().equals("exit")){
            Main.startMainMenu();
        }

        // Split User Input by ', '
        String[] inputParts = userInput.split(", ");
        int numberOfParts = inputParts.length;

        // Customer Object
        Customer customer = new Customer();

        //Create Different Customer Accordingly to User Inputs
        if (numberOfParts == 4){
            // Add attributes values of the inputs
            int cId1 = Integer.parseInt(inputParts[0]);
            String cName1 = inputParts[1];
            int cContactNumber1 = Integer.parseInt(inputParts[2]);
            String cEmail1 = inputParts[3];

            // Create customer
            customer = new Customer(cId1, cName1, cContactNumber1, cEmail1);
        } else {
            System.out.println("\nInvalid Option, Try Again...");
            Main.enterContinue();
            newCustomerDefaultAddress();
        }

        return customer;
    }
}
