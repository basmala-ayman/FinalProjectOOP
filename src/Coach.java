
import java.util.ArrayList;
import java.util.Scanner;

public class Coach extends Person {

    private float workingHours;
    private ArrayList<Customer> customers = new ArrayList();

    Scanner input = new Scanner(System.in);

    public void setCustomers(ArrayList<Customer> customers){
        this.customers=customers;
    }

    public void setWorkingHours(float workingHours) {
        this.workingHours = workingHours;
    }

//    public float getWorkingHours() {
//        return workingHours;
//    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getCustomersSize() {
        return customers.size();
    }

    public boolean canCustomerSubscribe() {
        return getCustomersSize() < 10;
    }

    public void displayCustomers() {
        System.out.println("Your Customers are:");
        System.out.println("--------------------");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println("Name of customer #" + (i + 1) + ": " + customers.get(i).getName());
        }
        System.out.println("---------------------------------------------------");
    }

    public void displayCustomerAccrodingName() {
        String name;
        int customerIndex = -1;
        System.out.print("Enter the Customer's Name to show his/her information: ");
        input.nextLine();
        name = input.nextLine();

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                customerIndex = i;
                break;
            }
        }
        try {
            customers.get(customerIndex).displayInfo();
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                    --------------
                    INVALID NAME!!
                    --------------""");
        }

    }

    public void displayCustomersAccrodingGender() {
        char gender;
        System.out.print("Enter the gender of customers you want to show: ");
        gender = input.next().charAt(0);
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getGender() == gender) {
                System.out.println("The name of Customer #" + (i + 1) + ": " + customers.get(i).getName());
            }
        }
    }

    public void displayInBodyHistory() {
        int customerId;
        int customerIndex = -1;
        System.out.print("Enter the Customer ID to show his/her In-Body history: ");
        customerId = input.nextInt();
        for (int i = 0; i < customers.size(); i++) {
            if (customerId == customers.get(i).getID()) {
                customerIndex = i;
                break;
            }
        }
        try {
            customers.get(customerIndex).displayInBodyDetails();
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                    ------------
                    INVALID ID!!
                    ------------""");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("The Coach's Name: " + getName());
        System.out.println("The Coach's Phone Number: " + getPhoneNumber());
        System.out.println("The Coach's Working Hours: " + workingHours);
        System.out.println("-----------------------------------------------");
    }
}

