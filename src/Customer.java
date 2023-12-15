

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
//import static testproject_24_11.MembershipPlan.parseDate;

public class Customer extends Person {

    private ArrayList<Subscription> subscriptions = new ArrayList();
    private ArrayList<InBody> inBodies = new ArrayList();

    Scanner input = new Scanner(System.in);

    // Setters
    public void setSubscriptions(ArrayList<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void setInBodies(ArrayList<InBody> inBodies) {
        this.inBodies = inBodies;
    }

    // Getters
    public ArrayList<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public ArrayList<InBody> getInBodies() {
        return inBodies;
    }

    @Override
    public void displayInfo() {
        System.out.println("------------------------------------------");
        System.out.println("The information of the Coach: " + getName());
        System.out.println("------------------------------------------");
        System.out.println("Phone number: " + getPhoneNumber());
        System.out.println("Gender: " + getGender());
        System.out.println("Email: " + getEmail());
        System.out.println("------------------------------------------");
    }

    // Display Coach Info of this Customer
    public void displayCoachInfo(ArrayList<Coach> coaches) {
        int subscriptionIndex = subscriptions.size() - 1;
        int coachIndex = -1;
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getID() == (subscriptions.get(subscriptionIndex).getCoachId())) {
                coachIndex = i;
                break;
            }
        }
        try {
            coaches.get(coachIndex).displayInfo();
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("You don't have a Coach yet!!");
        }
    }

    // Display Membership Plan
    public void displayMembershipPlan() {
        System.out.println("""
                -----------------------------
                Your Membership Plan Details:
                -----------------------------""");
        this.subscriptions.get(subscriptions.size() - 1).getMembershipPlan().displayInfo();
        System.out.println("------------------------------------------------------------");
    }

    // Display InBody Info at specific Date
    public void displayInBodyInfoAtDate() {
        String inBodyDate;
        int inBodyIndex = -1;
        System.out.print("Enter the date in format (dd-MM-yyyy) to display your In-Body details on it: ");
        inBodyDate = input.next();
        for (int i = 0; i < inBodies.size(); i++) {
            if (inBodies.get(i).getInBodyDate().equals(SearchDate.parseDate(inBodyDate))) {
                inBodyIndex = i;
                break;
            }
        }
        try {
            inBodies.get(inBodyIndex).displayInBodyDetails();
        } catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               --------------
                               INVALID DATE!!
                               --------------""");
        }
    }

    // Display the last InBody Details of this Customer
    public void displayInBodyDetails() {
        for (int i = 0; i < inBodies.size(); i++) {
            inBodies.get(i).displayInBodyDetails();
        }
    }

    // Display Kilos the Customer needs to reduced it
    public void displayKilos() {
        inBodies.get(inBodies.size() - 1).displayRecommendedWeightLoss();
        System.out.println("----------------------------------------------------");
    }

    // Display the Subscription History of this Customer
    public void displaySubscriptionHistory() {
        for (int i = 0; i < subscriptions.size(); i++) {
            System.out.println("Data of Customer's Subscription Plan number " + (i + 1) + " : ");
            System.out.println("Starts at: " + SearchDate.getStringDate(subscriptions.get(i).getMembershipPlan().getStartDate()));
            System.out.println("Number of months registered: " + subscriptions.get(i).getMembershipPlan().getMonthRegisterd());
            System.out.println("Number of Days per Week " + subscriptions.get(i).getMembershipPlan().getMonthlyPlan());

        }
    }

    // Display Available Coaches for the Customer to subscribe
    private void displayAvailableCoaches(ArrayList<Coach> coaches) {
        System.out.println("ID\t\tName");
        System.out.println("---\t\t-----");
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).canCustomerSubscribe()) {
                System.out.println(coaches.get(i).getID() + "\t\t" + coaches.get(i).getName());
            }
        }
        System.out.println("-------------------------------------------------------------");
    }

    // Add Subscription for the Customer to subscribe at the first time or to add another one
    public void addSubscription(ArrayList<Coach> coaches) {
        Subscription newSubscription = new Subscription();
        subscriptions.add(newSubscription);

        MembershipPlan newMembershipPlan = new MembershipPlan();
        newSubscription.setMembershipPlan(newMembershipPlan);

        System.out.println("""
                Choose one Coach from those available coaches:
                ----------------------------------------------""");
        displayAvailableCoaches(coaches);
        System.out.print("Enter the Coach Id you have chosen: ");
        int coachId = input.nextInt();
        int coachIndex = -1;
        for (int i = 0; i < coaches.size(); i++) {
            if (coaches.get(i).getID() == coachId) {
                coachIndex = i;
                break;
            }
        }
        try {
            if (coaches.get(coachIndex).canCustomerSubscribe()) {
                newSubscription.setCoachId(coachId);
                coaches.get(coachIndex).getCustomers().add(this);
            }
            else {
                System.out.println("This Coach has 10 Customers, so he/she can not take another Customer!");
            }
        }
        catch (IndexOutOfBoundsException exp) {
            System.out.println("""
                               -------------
                               INVALID ID!!
                               -------------""");
        }

        System.out.println("Enter your new Membership Plan details:");
        System.out.println("-----------------------------------------");
        while (true) {
            System.out.print("Enter the Start Date: ");
            try {
                newMembershipPlan.setStartDate(SearchDate.parseDate(input.next()));
                break;
            }
            catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        while (true) {
            System.out.print("Enter the Monthly Plan (3/6) days per month: ");

            try {
                newMembershipPlan.setMonthlyPlan(input.nextInt());
                if (newMembershipPlan.getMonthlyPlan() != 3 && newMembershipPlan.getMonthlyPlan()!= 6) {
                    throw new IllegalArgumentException("""
                                                       -----------------------
                                                       PLEASE, ENTER 3 OR 6!!
                                                       -----------------------""");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.print("Enter the Number of Months: ");
        newMembershipPlan.setMonthRegisterd(input.nextInt());
        System.out.println("-------------------------------------------------------------");
        System.out.println("The Price of the Membership Plan: " + newMembershipPlan.getPrice());
        System.out.println("Your Membership Plan will end at: " + SearchDate.getStringDate(newMembershipPlan.getEndDate()));
        System.out.println("-------------------------------------------------------------");
    }

    // Method to perform an in-body scan for a customer
    private boolean performInBodyScan(Date currentDate) {

//        System.out.print("Enter Date: ");
//        String stringCurrentDate = input.nextLine();
//        Date currentDate= SearchDate.parseDate(stringCurrentDate);
        // Check if it's been 30 days since the last in-body scan
        if (inBodies.isEmpty() || SearchDate.betweenDates(inBodies.get(inBodies.size() - 1).getInBodyDate(), currentDate) >= 30) {
            InBody inBody = new InBody();
            inBodies.add(inBody);
            return true; // In-body scan successful
        } else {
            return false; // In-body scan not allowed
        }
    }

    // Add In-Body for the Customer to set his In-Body at the first time or to add another one
    public void addInBody() {

        System.out.println("Enter your InBody details: ");
        System.out.println("---------------------------");
        System.out.print("Enter your InBody Date in format (dd-MM-yyyy): ");
        input.nextLine();
        String startDate= input.nextLine();
//        newInBody.setInBodyDate(SearchDate.parseDate(input.next()));
        Date date=SearchDate.parseDate(startDate);
        if(performInBodyScan(date)){
            float body;
            String unit;
            InBody newInBody = new InBody();
            newInBody.setInBodyDate(date);

            System.out.print("Enter your Height: ");
            body=input.nextFloat();
            System.out.print("Enter the Unit (prefers \"m\"): ");
            unit=input.next();
            newInBody.setHeight(body, unit);

            System.out.print("Enter your Total Weight: ");
            body=input.nextFloat();
            System.out.print("Enter the Unit (prefers \"Kg\"): ");
            unit=input.next();
            newInBody.setTotalWeight(body, unit);

            System.out.print("Enter your Body Fat Mass: ");
            body=input.nextFloat();
            System.out.print("Enter the Unit (prefers \"Kg\"): ");
            unit=input.next();
            newInBody.setBodyFatMass(body, unit);

            System.out.print("Enter your Minerals: ");
            body=input.nextFloat();
            System.out.print("Enter the Unit (prefers \"Kg\"): ");
            unit=input.next();
            newInBody.setMinerals(body, unit);

            System.out.print("Enter your Total Body Water: ");
            body=input.nextFloat();
            System.out.print("Enter the Unit (prefers \"Kg\"): ");
            unit=input.next();
            newInBody.setTotalBodyWater(body, unit);

            System.out.print("Enter your Protein: ");
            body=input.nextFloat();
            System.out.print("Enter the Unit (prefers \"Kg\"): ");
            unit=input.next();
            newInBody.setProtein(body, unit);

            newInBody.setGender(this.getGender());
            this.inBodies.add(newInBody);
            System.out.println("""
                    -------------------------------------------------------
                    You have entered your In-Body details successfully.
                    -------------------------------------------------------""");
        }
        else{
            System.out.println("""
                    -------------------------------------------------------------
                    Now, you are not allowed to perform another In-Body scan yet.
                    -------------------------------------------------------------""");

        }
    }
}