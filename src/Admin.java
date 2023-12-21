
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Admin {

    private final String USERNAME= "admin";
    private final String PASSWORD= "admin";
    Scanner input = new Scanner(System.in);

    // Log-In Function of Admin
    public boolean logIn() {
        String username, password;
        int count = 0;
        while (true) {
            System.out.print("Enter your Username: ");
            username = input.next();
            if (username.equals(this.USERNAME)) {
                count = 0;
                while (true) {
                    System.out.print("Enter your Password: ");
                    password = input.next();
                    if (password.equals(this.PASSWORD)) {
                        System.out.println("Your login has been completed successfully");
                        return true;
                    }
                    else {
                        System.out.println("------------------\n" +
                                "INVALID PASSWORD!!\n" +
                                "Please, try again.\n" +
                                "------------------");
                        count++;
                        if (count >= 3) {
                            System.out.println("----------------------------------------\n" +
                                               "You have run out of attempts to log in!!\n" +
                                               "Try again later.\n" +
                                               "----------------------------------------");
                            return false;
                        }
                    }
                }
            }
            else {
                System.out.println("-------------------\n"+
                           "INVALID USERNAME!!\n"+
                           "PLEASE, try again.\n"+
                           "-------------------");
                count++;
                if (count >= 3) {
                    System.out.println("""
                           -----------------------------------------
                           You have run out of attempts to log in!!
                           Try again later.
                           -----------------------------------------""");
                    return false;
                }
            }
        }
    }

    // Add Functions to check Sign Up Operation.
    //Coach Email must be special
    public boolean add(Coach newCoach, ArrayList<Coach> coaches) {
        for (int i = 0; i < coaches.size(); i++) {
            if (newCoach.getEmail().equals(coaches.get(i).getEmail())) {
                return false;
            }
        }
        return true;
    }
    //Customer Email must be special
    public boolean add(Customer newCustomer, ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            if (newCustomer.getEmail().equals(customers.get(i).getEmail())) {
                return false;
            }
        }
        return true;
    }

    // Add Functions

    //add coach info
    public void addCoach(ArrayList<Coach> coaches) {

        Coach newCoach = new Coach();

        System.out.print("Enter the name of the new coach: ");
        input.nextLine();
        newCoach.setName(input.nextLine());
        System.out.print("Enter The Coach Id: ");
        newCoach.setID(input.nextInt());
        while (true) {
            System.out.print("The Email of the new coach: ");
            newCoach.setEmail(input.next());
            if (newCoach.getEmail().indexOf('@') > 0) {
                System.out.print("Enter the Password of the new coach: ");
                input.nextLine();
                newCoach.setPassword(input.nextLine());
                System.out.print("Enter the Gender of the new coach: ");
                while (true) {
                    try {
                        newCoach.setGender(input.next().charAt(0));
                        if (newCoach.getGender()!='F'&&newCoach.getGender()!='f'&&newCoach.getGender()!='M'&&newCoach.getGender()!='m') {
                            throw new IllegalArgumentException("""
                                                       -----------------------
                                                       PLEASE, ENTER F OR M!!
                                                       -----------------------
                                                       Enter your Gender: """);
                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.err.print(e.getMessage());
                    }
                }
                System.out.print("Enter the Address of the new coach: ");
                input.nextLine();
                newCoach.setAddress(input.nextLine());
                System.out.print("Enter the Phone Number of the new coach: ");
                newCoach.setPhoneNumber(input.next());
                System.out.print("Enter the Working Hours of the new coach: ");
                newCoach.setWorkingHours(input.nextFloat());
                coaches.add(newCoach);
                System.out.println("""
                               ---------------------------------------
                               Congratulation!!
                               This Coach has been added successfully.
                               ---------------------------------------""");
                System.out.println("And his/her ID is: " + newCoach.getID());
                System.out.println("----------------------------------------------------");
                break;
            }
            else {
                System.out.println("""
                                   ------------------
                                   INVALID EMAIL!!
                                   PLEASE, try again.
                                   ------------------""");
            }
        }
    }
//add customer info
    public void addCustomer(ArrayList<Customer> customers) {

        Customer newCustomer = new Customer();

        System.out.print("Enter the name of the new customer: ");
        input.nextLine();
        newCustomer.setName(input.nextLine());
        System.out.print("Enter The Customer Id: ");
        newCustomer.setID(input.nextInt());
        while (true) {
            System.out.print("Enter the Email of the new customer: ");
            newCustomer.setEmail(input.next());
            if (newCustomer.getEmail().indexOf('@') > 0) {
                System.out.print("Enter the Password of the new customer: ");
                input.nextLine();
                newCustomer.setPassword(input.nextLine());
                System.out.print("Enter the Gender of the new customer: ");
                while (true) {

                    try {
                        newCustomer.setGender(input.next().charAt(0));
                        if (newCustomer.getGender()!='F'&&newCustomer.getGender()!='f'&&newCustomer.getGender()!='M'&&newCustomer.getGender()!='m') {
                            throw new IllegalArgumentException("""
                                                       -----------------------
                                                       PLEASE, ENTER F OR M!!
                                                       -----------------------
                                                       Enter your Gender: 
                                                       """

                            );

                        }
                        break;
                    } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                    }
                }
                System.out.print("Enter the Address of the new customer: ");
                input.nextLine();
                newCustomer.setAddress(input.nextLine());
                System.out.print("Enter the Phone Number of the new customer: ");
                newCustomer.setPhoneNumber(input.next());
                customers.add(newCustomer);
                System.out.println("""
                               Congratulation!!
                               This Customer has been added successfuly.
                               -----------------------------------------""");
                System.out.println("And his/her ID is: " + newCustomer.getID());
                System.out.println("----------------------------------------------------");
                break;
            } else {
                System.out.println("""
                                   ------------------
                                   INVALID EMAIL!!
                                   PLEASE, try again.
                                   ------------------""");
            }
        }
    }

    public void addEquipment(ArrayList<Equipment> equipments) {

        Equipment newEquipment = new Equipment();

        System.out.print("Enter the name of the new Equipment: ");
        input.nextLine();
        newEquipment.setName(input.nextLine());
        System.out.print("Enter the code of the new Equipment: ");
        newEquipment.setCode(input.next());
        System.out.print("Enter the Quantity of the new Equipment: ");
        newEquipment.setQuantity(input.nextInt());
        equipments.add(newEquipment);
    }

    // Delete Functions
    //delete with .remove
    public void deleteCoach(ArrayList<Coach> coaches) {
        int coachId;
        System.out.print("Enter the Coach ID you want to delete: ");
        coachId = input.nextInt();
        int coachIndex = -1;
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getID() == coachId) {
                coachIndex = i;
                break;
            }
        }
        try {
            System.out.println(coaches.get(coachIndex).getName() + " is deleted.");
            System.out.println("------------------------------------------");
            coaches.remove(coachIndex);
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               ------------
                               INVALID ID!!
                               ------------""");
        }
    }

    public void deleteCustomer(ArrayList<Customer> customers) {
        int customerId;
        System.out.print("Enter the Customer ID you want to delete: ");
        customerId = input.nextInt();
        int customerIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getID() == customerId) {
                customerIndex = i;
                break;
            }
        }
        try {
            System.out.println(customers.get(customerIndex).getName() + " is deleted.");
            System.out.println("------------------------------------------");
            customers.remove(customerIndex);

        } catch (IndexOutOfBoundsException exp) {
            System.out.println("Customers size "+customers.size());
            System.out.println("""
                               
                               ------------
                               INVALID ID!!
                               ------------""");
        }
    }

    public void deleteEquipment(ArrayList<Equipment> equipments) {
        String equipmentCode;
        System.out.print("Enter the Equipment Code you want to delete: ");
        equipmentCode = input.next();
        int equipmentIndex = -1;
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).getCode().equals(equipmentCode)) {
                equipmentIndex = i;
                break;
            }
        }
        try {
            System.out.println(equipments.get(equipmentIndex).getName() + " is deleted.");
            System.out.println("------------------------------------------");
            equipments.remove(equipmentIndex);
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               --------------
                               INVALID CODE!!
                               --------------""");
        }
    }

    // Edit information Functions
    public void editCoach(ArrayList<Coach> coaches) {
        char repeat;
        int coachId;
        int choice, coachIndex = -1;
        System.out.print("Enter the Coach ID you want to edit his/her information: ");
        coachId = input.nextInt();
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getID() == coachId) {
                coachIndex = i;
                break;
            }
        }
        try {
            boolean check = coaches.contains(coaches.get(coachIndex)); // to check if the coachId not invalid
            while (true) {
                System.out.println("""
                        Press:
                        ------
                        1 --> To edit the Name.
                        2 --> To edit the Password.
                        3 --> To edit the Address.
                        4 --> To edit the Phone Number.
                        5 --> To edit tht Working Hours.
                        6 --> To back.
                        ----------------------------------------""");
                choice = input.nextInt();
                if (choice == 6){
                    break;
                }
                if (choice == 1) { // To edit the Name.
                    System.out.print("Enter the Name: ");
                    input.nextLine();
                    coaches.get(coachIndex).setName(input.nextLine());
                    System.out.println("The Name is edited successfully.");
                    System.out.println("---------------------------------");
                    input.nextLine();
                }
                else if (choice == 2) { // To edit the Password.
                    System.out.print("Enter the Password: ");
                    input.nextLine();
                    coaches.get(coachIndex).setPassword(input.nextLine());
                    System.out.println("The Password is edited successfully.");
                    System.out.println("-------------------------------------");
                    input.nextLine();
                }
                else if (choice == 3) { // To edit the Address.
                    System.out.print("Enter the Address: ");
                    input.nextLine();
                    coaches.get(coachIndex).setAddress(input.nextLine());
                    System.out.println("The Address is edited successfully.");
                    System.out.println("------------------------------------");
                    input.nextLine();
                }
                else if (choice == 4) { // To edit the Phone Number.
                    System.out.print("Enter the Phone Number: ");
                    coaches.get(coachIndex).setPhoneNumber(input.next());
                    System.out.println("The Phone Number is edited successfully.");
                    System.out.println("-----------------------------------------");
                }
                else if (choice == 5) { // To edit tht Working Hours.
                    System.out.print("Enter the Working Hours: ");
                    coaches.get(coachIndex).setWorkingHours(input.nextInt());
                    System.out.println("The Working Hours is edited successfully.");
                    System.out.println("------------------------------------------");
                }
                else {
                    Main.invalidMsg();
                    continue;
                }
                System.out.print("Do you want to edit another thing (Y/N)?");
                repeat=input.next().charAt(0);
                System.out.println("-----------------------------------------------------");
                if(repeat!='y'&&repeat!='Y'){
                    break;
                }
            }
        }
        catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               ------------
                               INVALID ID!!
                               ------------""");
        }

    }

    public void editCustomer(ArrayList<Customer> customers) {
        char repeat;
        int customerId;
        int choice, customerIndex = -1;
        System.out.print("Enter the Customer ID you want to edit his/her information: ");
        customerId = input.nextInt();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getID() == customerId) {
                customerIndex = i;
                break;
            }
        }

        try {
            boolean check = customers.contains(customers.get(customerIndex)); // to check if the customerId not invalid?!!
            while (true) {
                System.out.println("""
                        Press:
                        ------
                        1 --> To edit the Name.
                        2 --> To edit the Password.
                        3 --> To edit the Address.
                        4 --> To edit the Phone Number.
                        5 --> To back.
                        --------------------------------------""");
                choice = input.nextInt();
                if (choice == 5){
                    break;
                }
                if (choice == 1) { // To edit the Name.
                    System.out.print("Enter the Name: ");
                    input.nextLine();
                    customers.get(customerIndex).setName(input.next());
                    System.out.println("The Name is edited successfully.");
                    System.out.println("---------------------------------");
                }
                else if (choice == 2) { // To edit the Password.
                    System.out.print("Enter the Password: ");
                    input.nextLine();
                    customers.get(customerIndex).setPassword(input.next());
                    System.out.println("The Password is edited successfully.");
                    System.out.println("-------------------------------------");
                }
                else if (choice == 3) { // To edit the Address.
                    System.out.print("Enter the Address: ");
                    input.nextLine();
                    customers.get(customerIndex).setAddress(input.nextLine());
                    System.out.println("The Address is edited successfully.");
                    System.out.println("------------------------------------");
                }
                else if (choice == 4) { // To edit the Phone Number.
                    System.out.print("Enter the Phone Number: ");
                    customers.get(customerIndex).setPhoneNumber(input.next());
                    System.out.println("The Phone Number is edited successfully.");
                    System.out.println("-----------------------------------------");
                }
                else {
                    Main.invalidMsg();
                    continue;
                }
                System.out.print("Do you want to edit another thing (Y/N)? ");
                repeat= input.next().charAt(0);
                System.out.println("----------------------------------------------------");
                if (repeat != 'y'&& repeat != 'Y'){
                    break;
                }
            }
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               ------------
                               INVALID ID!!
                               ------------""");
        }
    }

    public void editEquipment(ArrayList<Equipment> equipments) {
        String equipmentCode;
        char repeat;
        int choice, equipmentIndex = -1;
        System.out.print("Enter the Equipment Code you want to edit its information: ");
        equipmentCode = input.next();
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).getCode().equals(equipmentCode)) {
                equipmentIndex = i;
                break;
            }
        }

        try {
            // to check if the equipmentCode not invalid?!!
            boolean check = equipments.contains(equipments.get(equipmentIndex));
            while (true) {
                System.out.println("""
                        Press:
                        ------
                        1 --> To edit the Name.
                        2 --> To edit the Quantity.
                        3 --> To back.
                        ---------------------------""");
                choice = input.nextInt();
                if (choice == 3){
                    break;
                }
                if (choice == 1) { // To edit the Name.
                    System.out.print("Enter the Name: ");
                    input.nextLine();
                    equipments.get(equipmentIndex).setName(input.nextLine());
                    System.out.println("The Name is edited successfully.");
                    System.out.println("---------------------------------------");
                }
                else if (choice == 2) { // To edit the Quantity.
                    System.out.print("Enter the Quantity: ");
                    equipments.get(equipmentIndex).setQuantity(input.nextInt());
                    System.out.println("The Quantity is edited successfully.");
                    System.out.println("---------------------------------------");
                }
                else {
                    Main.invalidMsg();
                    continue;
                }
                System.out.print("Do you want to edit another thing (Y/N)? ");
                repeat= input.next().charAt(0);
                System.out.println("--------------------------------------------------");
                if (repeat != 'y'&& repeat != 'Y'){
                    break;
                }
            }
        }
        catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               --------------
                               INVALID CODE!!
                               --------------""");
        }
    }

    // Display Subscription History of a specific Customer
    public void displaySubscriptionHistory(ArrayList<Customer> customers) {
        int customerId;
        int customerIndex = -1;

        System.out.print("Enter the Customer ID to show his/her subscription history: ");
        customerId = input.nextInt();
      if(customers.size()!=0){
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getID() == customerId) {
                customerIndex = i;
                break;
            }
        }
        try {
            customers.get(customerIndex).displaySubscriptionHistory();
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                    ------------
                    INVALID ID!!
                    ------------""");
        }
    }  else {
          System.out.println("No added customers yet!");
      }
    }

    // Display Customers Subscribed in specific Date
    public void displayCustomersSubscribed(ArrayList<Customer> customers, ArrayList<Subscription> subscriptions) {

        int choice, count = 0;
        String date;
        char repeat;
        while (true) {
            System.out.println("""
                           Press:
                           ------
                           1 --> to enter a specific day.
                           2 --> to enter a specific month.
                           3 --> Back.
                           ---------------------------------""");
            choice = input.nextInt();
            if (choice==3) {
                break;
            }
            if (choice == 1) {
                System.out.print("Enter the day in format (dd-MM-yyyy): ");
                date = input.next();
                System.out.println("--------------------------------------------------");
                for (int i = 0; i < customers.size(); i++) {
                    for (int j = 0; j < customers.get(i).getSubscriptions().size(); j++) {
                        if (SearchDate.getDay(customers.get(i).getSubscriptions().get(j).getMembershipPlan().getStartDate()) == SearchDate.getDay(SearchDate.parseDate(date)) && SearchDate.getMonth(customers.get(i).getSubscriptions().get(j).getMembershipPlan().getStartDate()) == SearchDate.getMonth(SearchDate.parseDate(date)) && SearchDate.getYear(customers.get(i).getSubscriptions().get(j).getMembershipPlan().getStartDate()) == SearchDate.getYear(SearchDate.parseDate(date))) {
                            count++;
                            System.out.println((j+1) + ") " + customers.get(i).getName());
                        }
                    }
                }
                if (count == 0) {
                    System.out.println("No Subscriptions in this day: " + date);
                    System.out.println("--------------------------------------------");
                }
            }
            else if (choice == 2) {
                System.out.print("Enter the month in format (MM-yyyy): ");
                date = input.next();
                System.out.println("--------------------------------------------------");
//                System.out.println("Customers are subscribed in month (" + date + "):");
                for (int i = 0; i < customers.size(); i++) {
                    for (int j = 0; j < customers.get(i).getSubscriptions().size(); j++) {
                        if (SearchDate.getMonth(customers.get(i).getSubscriptions().get(j).getMembershipPlan().getStartDate()) == SearchDate.getMonth(SearchDate.parseDateMonth(date)) && SearchDate.getYear(customers.get(i).getSubscriptions().get(j).getMembershipPlan().getStartDate()) == SearchDate.getYear(SearchDate.parseDateMonth(date))) {
                            count++;
                            System.out.println(count + ") " + customers.get(i).getName());
//                            break;
                        }
                    }
                }
                if (count == 0) {
                    System.out.println("No Subscriptions in this month:" + date);
                    System.out.println("----------------------------------------------");
                }

            }
            else {
                Main.invalidMsg();
                continue;
            }
            System.out.print("Do you want to show the customers that subscribed to the gym again(y/n): ");
            repeat = input.next().charAt(0);
            if(repeat != 'y' && repeat != 'Y'){
                break;
            }
        }
    }

    // Display Customers Of a specific Coach
    public void displayCustomersOfACoach(ArrayList<Coach> coaches) {
        int coachId;
        int coachIndex = -1;
        System.out.print("Enter the Coach ID that you want his/her Customers: ");
        coachId = input.nextInt();
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getID() == coachId) {
                coachIndex = i;
                break;
            }
        }
        try {
            coaches.get(coachIndex).displayCustomers();
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("Invalid ID!!");
        }
    }

    // Display Gym Income in specific MONTH
    public void displayGymIncome(Gym ourGym) {

        String date;
        System.out.print("Enter the month in format (MM-yyyy) you want to know the GYM Income in it: ");
        date = input.next();
//        System.out.println(SearchDate.getMonth(SearchDate.parseDateMonth(date));
        ourGym.displayIncome(SearchDate.getMonth(SearchDate.parseDateMonth(date)), SearchDate.getYear(SearchDate.parseDateMonth(date)));
    }

    // Display Coaches Sorted Descinding
    public void displayCoachesSortedDesc(ArrayList<Coach> coaches) {
        if(!coaches.isEmpty()){
        coaches.sort(Comparator.comparing(Coach::getCustomersSize).reversed());
        System.out.println("The Coaches sorted in terms of the most assigned number of customers to the coaches:");
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < coaches.size(); i++) {
            System.out.println((i + 1) + ". " + coaches.get(i).getName()+" has "+ coaches.get(i).getCustomersSize() + " Customers.");
        }
        System.out.println("------------------------------------------------------");
    }
        else {
            System.out.println("No added coaches!");
        }
    }
}