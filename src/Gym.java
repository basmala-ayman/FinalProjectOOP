import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Gym {

    private String name, address, phoneNumber;
    private Admin admin = new Admin();
    private ArrayList<Equipment> equipments = new ArrayList();
    private ArrayList<Coach> coaches = new ArrayList();
    private ArrayList<Customer> customers = new ArrayList();
    private ArrayList<Subscription> subscriptions = new ArrayList();

    Scanner input = new Scanner(System.in);

    // Constructor
//    public Gym() {
//        name = "FITNESS GYM";
//        address = "Cairo";
//        phoneNumber = "19019";
//    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    public ArrayList<Coach> getCoaches() {
        return coaches;
    }

    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }

    // Setters
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Admin getAdmin() {
        return admin;
    }

    // Files Functions
    public void subscriptionFile() throws IOException {
//        ArrayList<Customer> people=new ArrayList<>();

        File file= new File("D://SubscriptionFile.txt");

        BufferedReader reader = null;
        String line2 = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line2 = reader.readLine()) != null) {
                String[] row = line2.split(",");
                Subscription newSubscription=new Subscription();
                MembershipPlan newMembershipPlan= new MembershipPlan();
                newSubscription.setCoachId(Integer.parseInt(row[0]));
                newSubscription.setCustomerId(Integer.parseInt(row[1]));
                newMembershipPlan.setStartDate(SearchDate.parseDate(row[2]));
                newMembershipPlan.setMonthlyPlan(Integer.parseInt(row[3]));
                newMembershipPlan.setMonthRegisterd(Integer.parseInt(row[4]));

                newSubscription.setMembershipPlan(newMembershipPlan);
                subscriptions.add(newSubscription);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            reader.close();
        }
    }

    // LogIn Functions
    public int logInCoach() {
        int id;
        String password;
        int coachIndex = -1, count = 0;
        while (true) {
            System.out.println("""
                    Log In by your ID and your Password:
                    ------------------------------------""");
            System.out.print("Enter your ID: ");
            id = input.nextInt();
            for (int i = 0; i < coaches.size(); i++) {
                if (id == coaches.get(i).getID()) {
                    coachIndex = i;
                    break; // from for loop
                }
            }
            if (coachIndex == -1) {
                count++;
                if (count >= 3) {
                    System.out.println("""
                                       -------------------------
                                       YOUR EMAIL IS NOT FOUND!!
                                       PLEASE, Sign Up.
                                       -------------------------""");
                    return coachIndex;
                }
                System.out.println("""
                           ------------------
                           INVALID ID!!
                           Please, try again.
                           ------------------""");
            } else {
                System.out.print("Enter your Password: ");
                password = input.next();
                if (password.equals(coaches.get(coachIndex).getPassword())) {
                    System.out.println("""
                                       -------------------------------------------
                                       Your login has been completed successfully.
                                       -------------------------------------------""");
//                    coach=coaches.get(coachIndex);
                    return coachIndex;
                }
                else {
                    count++;
                    if (count >= 3) {
                        System.out.println("""
                                               -----------------------------------------
                                               You have run out of attempts to log in!!
                                               Try again later.
                                               -----------------------------------------""");
                        return coachIndex;
                    }
                    System.out.println("""
                           -------------------
                           INVALID PASSWORD!!
                           Please, try again.
                           -------------------""");
                }
            }
        }
    }

    public int logInCustomer() {
        int id;
        String password;
        int customerIndex = -1, count = 0;
        while (true) {
            System.out.print("Enter your ID: ");
            id = input.nextInt();
            for (int i = 0; i < customers.size(); i++) {
                if (id==customers.get(i).getID()) {
                    customerIndex = i;
                    break; // from for loop
                }
            }
            if (customerIndex == -1) {
                count++;
                if (count >= 3) {
                    System.out.println("""
                                       --------------------------
                                       YOUR EMAIL IS NOT FOUND!!
                                       PLEASE, Sign Up.
                                       --------------------------""");
                    return customerIndex;
                }
                System.out.println("""
                           ------------------
                           INVALID ID!!
                           Please, try again.
                           ------------------""");
            } else {
                System.out.print("Enter your Password: ");
                password = input.next();
                if (password.equals(customers.get(customerIndex).getPassword())) {
                    System.out.println("""
                                       -------------------------------------------
                                       Your login has been completed successfully.
                                       -------------------------------------------""");
//                    customer= customers.get(customerIndex);
                    return customerIndex;
                }
                else {
                    count++;
                    if (count >= 3) {
                        System.out.println("""
                                               ----------------------------------------
                                               You have run out of attempts to log in!!
                                               Try again later.
                                               ----------------------------------------""");
                        return customerIndex;
                    }
                    System.out.println("""
                           -------------------
                           INVALID PASSWORD!!
                           Please, try again.
                           -------------------""");
                }
            }
        }
    }

    // SignUp Functions
    public void signUpCoach() {

        Coach newCoach = new Coach();
        System.out.println("""
                Enter your information to Sign Up:
                -----------------------------------""");

        System.out.print("Enter your Email: ");
        newCoach.setEmail(input.next());
        System.out.print("Enter your name: ");
        input.nextLine();
        newCoach.setName(input.nextLine());
        System.out.print("Enter your Password: ");
        newCoach.setPassword(input.nextLine());
        System.out.print("Enter your Gender (M/F): ");
        while (true) {
            try {
                newCoach.setGender(input.next().charAt(0));
                if (newCoach.getGender()!='F'&&newCoach.getGender()!='f'&&newCoach.getGender()!='M'&&newCoach.getGender()!='m') {
                    throw new IllegalArgumentException("""
                                                       -----------------------
                                                       PLEASE, ENTER F OR M!!
                                                       -----------------------
                                                       Enter your Gender: """
                    );
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("Enter your Phone Number: ");
        newCoach.setPhoneNumber(input.next());
        System.out.print("Enter your Working Hours: ");
        newCoach.setWorkingHours(input.nextFloat());
        System.out.print("Enter your Address: ");
        input.nextLine();
        newCoach.setAddress(input.nextLine());
        if (admin.add(newCoach, coaches)) {
            coaches.add(newCoach);
            System.out.println("""
                               ------------------------------------------------
                               Congratulation!!
                               Now, you have an account""");
            System.out.println("And your ID is: " + newCoach.getID());
            System.out.println("""
                    ------------------------------------------------
                    Please, Log-In to can access your functionality.
                    ------------------------------------------------""");
        } else {
            System.out.println("""
                    You have already an Account!!
                    Please, Log-In.""");
        }

//        input.nextLine();
    }

    public void signUpCustomer() {
        Customer newCustomer = new Customer();

        System.out.print("Enter your Name: ");
        newCustomer.setName(input.nextLine());
        System.out.print("Enter your Email: ");
        newCustomer.setEmail(input.next());
        input.nextLine();
        System.out.print("Enter your Password: ");
        newCustomer.setPassword(input.nextLine());
        System.out.print("Enter your Gender: ");
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


        System.out.print("Enter your Address: ");
        newCustomer.setAddress(input.nextLine());
        input.nextLine();
        System.out.print("Enter your Phone Number: ");
        newCustomer.setPhoneNumber(input.next());

        if (admin.add(newCustomer, customers)) {
            customers.add(newCustomer);
            System.out.println("""
                               Congratulation!!
                               Now, you have an account""");
            System.out.println("And your ID is: " + newCustomer.getID());
            System.out.println("------------------------------------------------");
            System.out.println("You should subscribe first to access our functionalities!");
            customers.get(customers.size()-1).addSubscription(coaches);
            customers.get(customers.size()-1).addInBody();
//            return true;
        } else {
            System.out.println("""
                    You have already an Account!!
                    Please, Log-In.""");
//            return false;
        }
    }

    // to display all equipment in the gym for the customer.
    public void displayEquipment() {
        System.out.println("The Equipment's Names in the GYM:");
        for (int i = 0; i < equipments.size(); i++) {
            System.out.print((i + 1) + "- " + equipments.get(i).getName() + ".");
        }
        System.out.println("-----------------------------------------------");
    }

    // To display the income of the gym in specific month for the admin
    public void displayIncome(int month, int year) {
        double finalIncome = 0;
        boolean found = false;
        for (int i = 0; i < subscriptions.size(); i++) {

            if (SearchDate.getMonth(subscriptions.get(i).getMembershipPlan().getStartDate()) == month && SearchDate.getYear(subscriptions.get(i).getMembershipPlan().getStartDate()) == year) {
                finalIncome += getSubscriptions().get(i).getMembershipPlan().getPrice();
                found = true;
            }

//            if (SearchDate.searchMonth(subscriptions.get(i).getMembershipPlan().getStartDate(), month)) {
//                finalIncome += getSubscriptions().get(i).getMembershipPlan().getPrice();
//                found = true;
//            }
        }
        if (found) {
            System.out.println("Total Income for the Gym in month (" + month + '-' + year + ") is: " + finalIncome);
        } else {
            System.out.println("""
                               ------------------
                               INVALID MONTH!!
                               Please, try again.
                               ------------------""");
        }
    }

    public void logOut(){
        System.out.println("""
                -----------------------------------
                Thank You :)
                Your Log-Out has been successfully.
                -----------------------------------""");
    }

}
