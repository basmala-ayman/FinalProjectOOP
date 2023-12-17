
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Gym {
    private String name, address, phoneNumber;
    private Admin admin = new Admin();
    private ArrayList<Equipment> equipments = new ArrayList<>();
    private ArrayList<Coach> coaches = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Subscription> subscriptions = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    // Constructor
    public Gym(String name, String address, String phoneNumber){
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }
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

        String file = "SubcriptionFile";

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

    public void writeToSubscriptionFile() throws IOException {
        String file = "SubcriptionFile";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            String line = "";
            for (Subscription s : subscriptions) {
//                writer.write(s.toString());

                String[] row = new String[5];
                row[0] =Integer.toString(s.getCoachId()) ;
                row[1]=Integer.toString(s.getCustomerId());

                row[2]= SearchDate.getStringDate(s.getMembershipPlan().getStartDate());
                row[3]= Integer.toString(s.getMembershipPlan().getMonthlyPlan());
                row[4]=Integer.toString(s.getMembershipPlan().getMonthRegisterd());

                line = String.join(",", row);
                writer.write(line);
                writer.newLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            writer.close();
        }
    }

        public void customerFile() throws IOException {

            String file = "CustomerFile";
            BufferedReader reader = null;
            String line2 = "";

            try {
                reader = new BufferedReader(new FileReader(file));
                while((line2 = reader.readLine()) != null) {
                    String[] row = line2.split(",");
                    int rowSize = row.length;

                    Customer newCustomer = new Customer();
                    ArrayList<InBody> newInbodies = new ArrayList<>();

                    newCustomer.setEmail((row[0]));
                    newCustomer.setID(Integer.parseInt((row[1])));
                    newCustomer.setName((row[2]));
                    newCustomer.setPassword((row[3]));
                    newCustomer.setAddress((row[4]));
                    newCustomer.setPhoneNumber(row[5]);
                    newCustomer.setGender(row[6].charAt(0));
                    int count = 7;
                    while (count < rowSize){
                        InBody newInBody = new InBody();
                        newInBody.setInBodyDate(SearchDate.parseDate(row[count]));
                        count++;
                        newInBody.setHeight(Float.parseFloat(row[count]),row[++count]);
                        count++;
                        newInBody.setTotalWeight(Float.parseFloat(row[count]),row[++count]);
                        count++;
                        newInBody.setBodyFatMass(Float.parseFloat(row[count]),row[++count]);
                        count++;
                        newInBody.setMinerals(Float.parseFloat(row[count]),row[++count]);
                        count++;
                        newInBody.setTotalBodyWater(Float.parseFloat(row[count]),row[++count]);
                        count++;
                        newInBody.setProtein(Float.parseFloat(row[count]),row[++count]);
                        count++;
                        newInbodies.add(newInBody);
                    }
                    newCustomer.setInBodies(newInbodies);
                    customers.add(newCustomer);
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            finally {
                reader.close();
            }
        }

    public void writeToCustomerFile()throws IOException {
                String file = "CustomerFile";
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(file));
                    String line = "";
                    for (Customer cu : customers) {
                        int size = 7 + (cu.getInBodies().size()*13);
                        String[] row = new String[size];
                        row[0] = cu.getEmail();
                        row[1] = Integer.toString(cu.getID());
                        row[2] = cu.getName();
                        row[3] = cu.getPassword();
                        row[4] = cu.getAddress();
                        row[5] = cu.getPhoneNumber();
                        row[6] = Character.toString(cu.getGender());
                        int count =7;
                        for (int i=0; i < cu.getInBodies().size(); i++) {

                            row[count] = SearchDate.getStringDate(cu.getInBodies().get(i).getInBodyDate());
                            count++;

                            row[count]=Float.toString(cu.getInBodies().get(i).getHeight());
                            count++;
                            row[count]=cu.getInBodies().get(i).getUnits()[0];
                            count++;

                            row[count]=Float.toString(cu.getInBodies().get(i).getTotalWeight());
                            count++;
                            row[count]=cu.getInBodies().get(i).getUnits()[1];
                            count++;

                            row[count]=Float.toString(cu.getInBodies().get(i).getBodyFatMass());
                            count++;
                            row[count]=cu.getInBodies().get(i).getUnits()[2];
                            count++;

                            row[count]=Float.toString(cu.getInBodies().get(i).getMinerals());
                            count++;
                            row[count]=cu.getInBodies().get(i).getUnits()[3];
                            count++;

                            row[count]=Float.toString(cu.getInBodies().get(i).getTotalBodyWater());
                            count++;
                            row[count]=cu.getInBodies().get(i).getUnits()[4];
                            count++;

                            row[count]=Float.toString(cu.getInBodies().get(i).getProtein());
                            count++;
                            row[count]=cu.getInBodies().get(i).getUnits()[5];
                            count++;

                        }
                        line = String.join(",", row);
                        writer.write(line);
                        writer.newLine();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    writer.close();
                }
        }

    public void equipmentFile() throws IOException {
    String file = "EquipmentFileTest";
    BufferedReader reader = null;
    String line2 = "";
    try {
        reader = new BufferedReader(new FileReader(file));
        while((line2 = reader.readLine()) != null) {
            String[] row = line2.split(",");
            Equipment newEquipment = new Equipment();
            newEquipment.setName(row[0]);
            newEquipment.setCode(row[1]);
            newEquipment.setQuantity(Integer.parseInt(row[2]));
            equipments.add(newEquipment);
        }
    }
    catch(Exception e) {
        e.printStackTrace();
    }
    finally {
        reader.close();
    }
}

    public void writeToEquipmentFile(ArrayList<Equipment> equipments) throws IOException {
    //System.out.println(equipments.size());
    //System.out.println(equipments.size());
    String file = "EquipmentFileTest";
    BufferedWriter writer = null;
    try {
        writer = new BufferedWriter(new FileWriter(file));
        String line = "";
        for (Equipment eq : equipments) {
            String[] row = new String[3];
            row[0] = eq.getName();
            row[1] = eq.getCode();
            row[2] = Integer.toString(eq.getQuantity());
            line = String.join(",", row);
            writer.write(line);
            writer.newLine();
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    finally {
        writer.close();
    }
}

    public void coachFile() throws IOException {

    String file = "CoachFile";

    BufferedReader reader = null;
    String line2 = "";
    try {
        reader = new BufferedReader(new FileReader(file));
        while((line2 = reader.readLine()) != null) {
            String[] row = line2.split(",");
            Coach newCoach = new Coach();
            newCoach.setEmail((row[0]));
            newCoach.setID(Integer.parseInt(row[1]));
            newCoach.setName((row[2]));
            newCoach.setPassword((row[3]));
            newCoach.setAddress((row[4]));
            newCoach.setPhoneNumber(row[5]);
            newCoach.setGender(row[6].charAt(0));
            newCoach.setWorkingHours(Float.parseFloat(row[7]));

            coaches.add(newCoach);
        }
    }
    catch(Exception e) {
        e.printStackTrace();
    }
    finally {
        reader.close();
    }
}

    public void writeToCoachFile()throws IOException {
            String file = "CoachFile";
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(file));
                String line = "";
                for (Coach co : coaches) {

                    String[] row = new String[8];
                    row[0] = co.getEmail();
                    row[1] = Integer.toString(co.getID());
                    row[2] = co.getName();
                    row[3] = co.getPassword();
                    row[4] = co.getAddress();
                    row[5] = co.getPhoneNumber();
                    row[6] = Character.toString(co.getGender());
                    row[7] = Float.toString(co.getWorkingHours());
                    line = String.join(",", row);
                    writer.write(line);
                    writer.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writer.close();
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
                           YOUR ID IS NOT FOUND!!
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
                input.nextLine();
                password = input.nextLine();
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
//        System.out.println("""
//    Enter your information to Sign Up:
//    Enter your information to Log in:
//    -----------------------------------""");
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
            }
            else {
                System.out.print("Enter your Password: ");
                input.nextLine();
                password = input.nextLine();
                if (password.equals(customers.get(customerIndex).getPassword())) {
                    System.out.println("""
                           -------------------------------------------
                           Your login has been completed successfully.
                           -------------------------------------------""");
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
               PLEASE, try again.
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
        while (true) {
            System.out.print("Enter your Email: ");
            newCoach.setEmail(input.next());

            System.out.print("Enter an Id: ");
            newCoach.setID(input.nextInt());
            if (newCoach.getEmail().indexOf('@') > 0) {
                System.out.print("Enter your name: ");
                input.nextLine();
                newCoach.setName(input.nextLine());
                System.out.print("Enter your Password: ");
                newCoach.setPassword(input.nextLine());
                while (true) {
                    System.out.print("Enter your Gender (M/F): ");
                    try {
                        newCoach.setGender(input.next().charAt(0));
                        if (newCoach.getGender() != 'F' && newCoach.getGender() != 'f' && newCoach.getGender() != 'M' && newCoach.getGender() != 'm') {
                            throw new IllegalArgumentException("""
                        -----------------------
                        PLEASE, ENTER F OR M!!
                        -----------------------"""
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
                }
                else {
                    System.out.println("""
                You have already an Account!!
                Please, Log-In.""");
                }
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
//        System.out.print("Enter your name: ");
//        input.nextLine();
//        newCoach.setName(input.nextLine());
//        System.out.print("Enter your Password: ");
//        newCoach.setPassword(input.nextLine());
//        System.out.print("Enter your Gender (M/F): ");
//        while (true) {
//            try {
//                newCoach.setGender(input.next().charAt(0));
//                if (newCoach.getGender()!='F'&&newCoach.getGender()!='f'&&newCoach.getGender()!='M'&&newCoach.getGender()!='m') {
//                    throw new IllegalArgumentException("""
//                                                       -----------------------
//                                                       PLEASE, ENTER F OR M!!
//                                                       -----------------------
//                                                       Enter your Gender: """
//                    );
//                }
//                break;
//            } catch (IllegalArgumentException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//        System.out.print("Enter your Phone Number: ");
//        newCoach.setPhoneNumber(input.next());
//        System.out.print("Enter your Working Hours: ");
//        newCoach.setWorkingHours(input.nextFloat());
//        System.out.print("Enter your Address: ");
//        input.nextLine();
//        newCoach.setAddress(input.nextLine());
//        if (admin.add(newCoach, coaches)) {
//            coaches.add(newCoach);
//            System.out.println("""
//                               ------------------------------------------------
//                               Congratulation!!
//                               Now, you have an account""");
//            System.out.println("And your ID is: " + newCoach.getID());
//            System.out.println("""
//                    ------------------------------------------------
//                    Please, Log-In to can access your functionality.
//                    ------------------------------------------------""");
//        } else {
//            System.out.println("""
//                    You have already an Account!!
//                    Please, Log-In.""");
//        }
//        input.nextLine();
    }
        public void signUpCustomer() {
        Customer newCustomer = new Customer();
        while (true) {
            System.out.print("Enter your Email: ");
            newCustomer.setEmail(input.next());
            System.out.print("Enter an Id: ");
            newCustomer.setID(input.nextInt());
            input.nextLine();
            if (newCustomer.getEmail().indexOf('@') > 0) {
                System.out.print("Enter your Name: ");
                newCustomer.setName(input.nextLine());
                System.out.print("Enter your Password: ");
                newCustomer.setPassword(input.nextLine());
                while (true) {
                    System.out.print("Enter your Gender: ");
                    try {
                        newCustomer.setGender(input.next().charAt(0));
                        if (newCustomer.getGender() != 'F' && newCustomer.getGender() != 'f' && newCustomer.getGender() != 'M' && newCustomer.getGender() != 'm') {
                            throw new IllegalArgumentException("""
                        -----------------------
                        PLEASE, ENTER F OR M!!
                        -----------------------"""
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
                    customers.get(customers.size() - 1).addSubscription(coaches);
                    customers.get(customers.size() - 1).addInBody();
                }
                else {
                    System.out.println("""
                You have already an Account!!
                Please, Log-In.""");
                }
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
        // to display all equipment in the gym for the customer.
        public void displayEquipment() {
        System.out.println("""
    ---------------------------------
    The Equipment's Names in the GYM:
    ---------------------------------""");
        for (int i = 0; i < equipments.size(); i++) {
            System.out.println((i + 1) + "- " + equipments.get(i).getName() + ".");
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
        }
        if (found) {
            System.out.println("Total Income for the Gym in month (" + month + '-' + year + ") is: " + finalIncome);
        }
        else {
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
        public void subscriptionInCustomer(){
        for (int i = 0; i<customers.size();i++){
            ArrayList <Subscription> newSubscriptionList = new ArrayList<>();
            for (int j = 0; j<subscriptions.size();j++) {
                if (subscriptions.get(j).getCustomerId() == customers.get(i).getID()) {
                    newSubscriptionList.add(subscriptions.get(j));
                }
            }
            customers.get(i).setSubscriptions(newSubscriptionList);
        }
    }
        public void subscriptionInCoach(){
        for (int i = 0; i<coaches.size();i++){
            ArrayList<Customer> newCustomerList = new ArrayList<>();
            for (int j = 0; j<subscriptions.size();j++) {
                if (subscriptions.get(j).getCoachId() == coaches.get(i).getID()) {
                    for (int k = 0; k<customers.size();k++){
                        if(subscriptions.get(j).getCustomerId()==customers.get(k).getID()){
                            newCustomerList.add(customers.get(k));
                        }
//                        break;
                    }
//                    newSubscriptionList.add(subscriptions.get(j));
                }
            }
            coaches.get(i).setCustomers(newCustomerList);
        }
    }
    }
