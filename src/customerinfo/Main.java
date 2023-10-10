package customerinfo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    /* Main Code - While Loop */
    public static void main(String[] args) {

        while (true){
            startMainMenu();
        }
    }

    // Scanner Input from User
    private static Scanner scanner = new Scanner(System.in);

    private static List<Customer> customerList = new ArrayList<Customer>();

    /* Main Methods */

    // Method to Start Main Menu

    public static void startMainMenu(){
        System.out.println("\n--------------------------------");
        System.out.println("            Main Menu             ");
        System.out.println("--------------------------------");

        System.out.println("/ Select an Option /\n");
        System.out.println("[1] Add Customer Information with default address");
        System.out.println("[2] Add extra address in specific customer");
        System.out.println("[3] Remove customer information based on customer id");
        System.out.println("[4] Find customer information with all addresses based on customer id");
        System.out.println("[5] Display all customer information with all addresses");
        System.out.println("\n[0] Exit");
        System.out.print("\n/: ");

        menuOptionSelection();
    }

    // Method to Scan the Selected Option from User and Switch Accordingly
    private static void menuOptionSelection(){
        int result = scanner.nextInt();
        scanner.nextLine();

        switch (result){
            case 1:
                // Create and List new Customer with default Address
                customerList.add(Customer.newCustomerDefaultAddress());

                System.out.println("\nCustomer Added Successfully!");
                enterContinue();
                break;

            case 2:
                // Check for an empty list
                checkEmptyList();

                displayCustomerList();
                System.out.println("\nEnter Customer ID to add a new Address: ");
                System.out.print("\n/: ");
                int customerId = scanner.nextInt();
                scanner.nextLine();

                // Check if customer exists on the list and assign its value
                Customer customer = customerById(customerId);

                // Add new address to specific customer
                addNewAddressForCustomer(customer);
                break;

            case 3:
                checkEmptyList();
                // Select a customer from the list
                Customer customer3 = selectCustomerFromList();

                System.out.println("\nAre you sure you want to delete the information of this customer?");
                System.out.println("-- Yes    -- No");
                System.out.print("\n/: ");
                String input = scanner.nextLine();

                if (input.toLowerCase().equals("yes")){
                    customerList.remove(customer3);
                    System.out.println("\nCustomer Removed Successfully");
                }
                enterContinue();
                break;

            case 4:
                checkEmptyList();
                Customer customer4 = selectCustomerFromList();
                customer4.printCustomerInfo();
                Main.enterContinue();
                break;

            case 5:

                for (Customer customers : customerList) {
                    System.out.println("\n/////////////////////////////////////////");
                    System.out.println("##########################################");
                    System.out.println("//////////////////////////////////////////");
                    customers.printCustomerInfo();
                    System.out.println("\n//////////////////////////////////////////");
                    System.out.println("###########################################");
                    System.out.println("///////////////////////////////////////////");
                }
                enterContinue();
                break;

            case 0:
                System.out.println("\nSee Ya :b");
                System.exit(0);
                break;

            default:
                System.out.println("\nInvalid Option, Try Again...");
                enterContinue();
                break;
        }
    }

    // Display "Enter to Continue" Option
    public static void enterContinue(){
        System.out.println("\nPress Enter to Continue...");
        scanner.nextLine();
    }

    // Check for an empty list
    private static void checkEmptyList(){
        if (customerList.size() < 1){
            System.out.println("There are no existing customers.");
            startMainMenu();
        }
    }

    // Check for existing customer by its id
    private static Customer customerById(int id){
        Customer customerExists = new Customer();

        // Loop to check if ID exists on the customers list
        for (int i = 0; i < customerList.size(); i++){
            if(customerList.get(i).getId() == id){
                customerExists = customerList.get(i);
            }
        }

        // Check if customer exists on the list
        if(!customerList.contains(customerExists)){
            System.out.println("Customer doesn't exist, please enter a valid Customer ID.");
            startMainMenu();
        }

        return customerExists;
    }

    // Method to add new address to specific customer
    public static void addNewAddressForCustomer(Customer customer){
        System.out.println("\n--------------------------------");
        System.out.println("           New Address           ");
        System.out.println("--------------------------------");
        System.out.println("* Notes: \n- Leave a Space After a Comma");
        System.out.println("- Assign Values in Format Order");
        System.out.println("- Type 'Exit' to Go Back to Main Menu");
        System.out.println("--------------------------------\n");
        System.out.print("Enter new Address Values (House Number, Street Name, City, Province, Country, Postal Code: ");

        String userInput = scanner.nextLine();

        if (userInput.toLowerCase().equals("exit")){
            Main.startMainMenu();
        }

        // Split User Input by ', '
        String[] inputParts = userInput.split(", ");
        int numberOfParts = inputParts.length;

        Address newAddress = null;

        if (numberOfParts == 6){
            // Add attributes values of the inputs
            int houseNumber = Integer.parseInt(inputParts[0]);
            String streetName = inputParts[1];
            String city = inputParts[2];
            String province = inputParts[3];
            String country = inputParts[4];
            String postalCode = inputParts[5];

            // Create new Address Object
            newAddress = new Address(houseNumber, streetName, city, province, country, postalCode);

        } else {
            System.out.println("\nInvalid Option, Try Again...");
            Main.enterContinue();
            addNewAddressForCustomer(customer);
        }

        //loop to retrieve courses of specific student and add new course into the existing course list
        for (int i=0; i<customerList.size(); i++){
            if(customerList.get(i).getId() == customer.getId()){
                customerList.get(i).getAddressList().add(newAddress);
                System.out.println("\nNew Address successfully added to Customer with ID: " + customer.getId());
                enterContinue();
            }
        }

    }

    // Display List of Customers to select a customer by its ID
    private static Customer selectCustomerFromList(){
        displayCustomerList();
        System.out.print("\n/: ");

        int input = scanner.nextInt();
        scanner.nextLine();

        return customerById(input);
    }

    // Display List of Customer
    private static void displayCustomerList(){
        System.out.println("\n--------------------------------");
        System.out.println("     Customer Selection           ");
        System.out.println("--------------------------------\n");
        System.out.println("Select Customer Id: \n");

        for (Customer customer : customerList) {
            System.out.println("- [" + customer.getId() + "] " + customer.getName());
        }
    }
}
