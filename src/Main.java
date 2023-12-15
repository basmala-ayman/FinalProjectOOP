import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void invalidMsg() {
        System.out.println("""
                ------------------
                INVALID CHOICE!!
                Please, try again.
                ------------------""");
    }

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

        Gym ourGym = new Gym();
        int choice;
        char repeat;

        ourGym.subscriptionFile();
//        for (int i=0;i<ourGym.getSubscriptions().size();i++){
//            System.out.println(ourGym.getSubscriptions().get(i).getCoachId()+" "
//                    +ourGym.getSubscriptions().get(i).getCustomerId() +" "
//                    +ourGym.getSubscriptions().get(i).getMembershipPlan().getMonthlyPlan() +" "
//            +ourGym.getSubscriptions().get(i).getMembershipPlan().getMonthRegisterd());
//        }

        while (true) {
            System.out.println("\t\tWelcome to Our GYM");
            System.out.println("\t--------------------------");
            System.out.println("""
                    Press:
                    ------
                    1 --> If you are an Admin.
                    2 --> If you are a Coach.
                    3 --> If you are a Customer.
                    -----------------------------""");
            choice = input.nextInt();
            // if the user is Admin
            if (choice == 1) { // If the user is an admin
                if (ourGym.getAdmin().logIn()) {
                    while (true) {
                        System.out.println("""
                                Press:
                                ------
                                1 --> To add (Coach, customer, equipment).
                                2 --> To delete (Coach, customer, equipment).
                                3 --> To edit (Coach, customer, equipment).
                                4 --> To display Subscription History.
                                5 --> To display Customers Subscribed in a specific day or month.
                                6 --> To display Customers of a specific Coach.
                                7 --> To display Gym Income in a specific month.
                                8 --> To display Coaches Sorted Descending.
                                9 --> Back.
                                ------------------------------------------------------------------""");
                        choice = input.nextInt();
                        if (choice == 1) { // to add
                            while (true) {
                                System.out.println("""
                                        Press:
                                        -------
                                        1 --> To add a Coach.
                                        2 --> To add a Customer.
                                        3 --> To add an Equipment.
                                        4 --> back
                                        -----------------------------""");
                                choice = input.nextInt();
                                if (choice == 1) { // To add a Coach.
                                    do {
                                        ourGym.getAdmin().addCoach(ourGym.getCoaches());
                                        System.out.print("Do you want to add another Coach (Y/N)? ");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if (choice == 2) { // To add a Customer.
                                    do {
                                        ourGym.getAdmin().addCustomer(ourGym.getCustomers());
                                        System.out.print("Do you want to add another Customer (Y/N)? ");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if (choice == 3) { // To add an Equipment.
                                    do {
                                        ourGym.getAdmin().addEquipment(ourGym.getEquipments());
                                        System.out.print("Do you want to add another Equipment (Y/N)? ");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if(choice==4){
                                   break;
                                }
                                else {
                                    invalidMsg();
                                    continue;
//                                        break;
                                }
                                System.out.print("Do you want to add another one/thing (Y/N)? ");
                                repeat = input.next().charAt(0);
                                if (repeat != 'y' && repeat != 'Y') {
                                    break;
                                }
                            }
                        }
                        else if (choice == 2) { // To delete
                            while (true) {
                                System.out.println("""
                                        Press:
                                        ------
                                        1 --> To delete a Coach."
                                        2 --> To delete a Customer."
                                        3 --> To delete an Equipment."
                                        4 --> Back
                                        ------------------------------""");
                                choice = input.nextInt();
                                switch (choice) {
                                    case 1: // To delete a Coach.
                                        ourGym.getAdmin().deleteCoach(ourGym.getCoaches());
                                        break;
                                    case 2: // To delete a Customer.
                                        ourGym.getAdmin().deleteCustomer(ourGym.getCustomers());
                                        break;
                                    case 3: // To delete an Equipment.
                                        ourGym.getAdmin().deleteEquipment(ourGym.getEquipments());
                                        break;
                                    case 4:
                                        break;
                                    default:
                                        invalidMsg();
                                        continue;
//                                        break;
                                }
                                System.out.print("Do you want to delete another one/thing (y/n)? ");
                                repeat = input.next().charAt(0);
                                if (repeat != 'y' && repeat != 'Y') {
                                    break;
                                }
                            }
//                            break;
                        }
                        else if (choice == 3) { // to edit
                            while (true) {
                                System.out.println("""
                                        Press:
                                        ------
                                        1 --> To edit a Coach.
                                        2 --> To edit a Customer.
                                        3 --> To edit an Equipment.
                                        4 --> Back.
                                        ----------------------------""");
                                choice = input.nextInt();
                                if (choice < 1 || choice > 4) {
                                    invalidMsg();
                                    continue;
                                }
                                if (choice == 1) { // To edit a Coach.
                                    do {
                                        ourGym.getAdmin().editCoach(ourGym.getCoaches());
                                        System.out.println("Do you want to edit another Coach (Y/N)?");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if (choice == 2) { // To edit a Customer.
                                    do {
                                        ourGym.getAdmin().editCustomer(ourGym.getCustomers());
                                        System.out.println("Do you want to edit another Customer (Y/N)?");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if (choice == 3) { // To edit an Equipment.
                                    do {
                                        ourGym.getAdmin().editEquipment(ourGym.getEquipments());
                                        System.out.println("Do you want to edit another Coach (Y/N)?");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if (choice == 4) {
                                    break;
                                }
                                else {
                                    invalidMsg();
                                    continue;
                                }
                                System.out.println("--------------------------------------------------");
                                System.out.print("Do you want to edit another one/thing (Y/N)? ");
                                repeat = input.next().charAt(0);
                                if (repeat != 'y' && repeat != 'Y') {
                                    break;
                                }
                            }
                        }
                        else if (choice == 4) { // To display Subscription History.
                            do {
                                ourGym.getAdmin().displaySubscriptionHistory(ourGym.getCustomers());
                                System.out.print("Do you want to show subscription history of another customer (Y/N)? ");
                                repeat = input.next().charAt(0);
                            } while (repeat == 'y' || repeat == 'Y');
//                            break;
                        }
                        else if (choice == 5) { // To display Customers Subscribed in a specific day or month.
                            do {
                                ourGym.getAdmin().displayCustomersSubscribed(ourGym.getCustomers(), ourGym.getSubscriptions());
                                System.out.println("Do you want to show customers in another date (y/n)?");
                                repeat = input.next().charAt(0);
                            } while (repeat == 'y' || repeat == 'Y');
                        }
                        else if (choice == 6) { // To display Customers of a specific Coach.
                            do {
                                ourGym.getAdmin().displayCustomersOfACoach(ourGym.getCoaches());
                                System.out.print("Do you want to show customers of another coach (Y/N)? ");
                                repeat = input.next().charAt(0);
                            } while (repeat == 'y' || repeat == 'Y');
//                            break;
                        }
                        else if (choice == 7) { // To display Gym Income in a specific month.
                            do {
                                ourGym.getAdmin().displayGymIncome(ourGym);
                                System.out.print("Do you want to show the income in another month (Y/N)? ");
                                repeat = input.next().charAt(0);
                            } while (repeat == 'y' || repeat == 'Y');
//                            break;
                        }
                        else if (choice == 8) { // To display Coaches Sorted Descending.
                            ourGym.getAdmin().displayCoachesSortedDesc(ourGym.getCoaches());
                        }
                        else if(choice==9){
                            break;
                        }
                        else {
                            invalidMsg();
                            continue;
                        }
                        do {
                            System.out.println("""
                                    Press:
                                    ------
                                    1 --> To do another operation.
                                    2 --> To Log Out.
                                    -------------------------------""");
                            choice = input.nextInt();
                            if (choice == 1) { // To do another operation.
                                break;
                            }
                            else if (choice == 2) { // To Log Out.
                                ourGym.logOut();
                                break;
                            }
                            else {
                                Main.invalidMsg();
                                continue;
                            }
                        } while (true);
                        if (choice==1){
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                }

                else {
                    System.out.println("You are not an admin!");
                    System.out.println("-----------------------------");
                    continue;
                }
                System.out.print("Do you want to Exit from the Our Gym (Y/N)? ");
                repeat = input.next().charAt(0);
                if (repeat!='y'&& repeat!='Y'){
                    continue;
                }
                else {
                    ourGym.logOut();
                    break;
                }
            }
            else if (choice == 2) {// if the user is a coach
                while (true) {
                    boolean login = false;
                    System.out.println("""
                            Press:
                            ------
                            1 --> To Sign Up, if you do not have an account.
                            2 --> To Log In, if you already have an account.
                            3 --> Back.
                            -------------------------------------------------""");
                    choice= input.nextInt();
                    if (choice==1){
                        ourGym.signUpCoach();
                        login = true;
                    }
                    if (choice == 2 || login) {
                        while (true){
                            int coachIndex = ourGym.logInCoach();
                            if (coachIndex != -1) {
                                if (ourGym.getCoaches().get(coachIndex).getCustomers().isEmpty()) {
                                    System.out.println("You do not have any Customers yet!");
                                    System.out.println("Thank you");
                                    System.out.println("-------------------------------------------------");
                                    break;
                                }
                                while (true) {
                                    System.out.println("""
                                            Press:
                                            -------
                                            1 --> To show a list of all your customers.
                                            2 --> To get the In-Body history of any your customers.
                                            3 --> To get all the details of a customer (Accroding his/her Name).
                                            4 --> To show a list of all his female/male customers.
                                            ----------------------------------------------------------------------""");
                                    choice = input.nextInt();
                                    //
                                    if (choice == 1) { //To show a list of all your customers.
                                        ourGym.getCoaches().get(coachIndex).displayCustomers();
                                    }
                                    else if (choice == 2) {//To get the In-Body history of any your customers.
                                        do {
                                            ourGym.getCoaches().get(coachIndex).displayInBodyHistory();
                                            System.out.print("Do you want to show the In-Body History of another customer (Y/N)? ");
                                            repeat = input.next().charAt(0);
                                        } while (repeat == 'y' || repeat == 'Y');
                                    }
                                    else if (choice == 3) { //  To get all the details of a customer (Accroding his/her Name).
                                        do {
                                            ourGym.getCoaches().get(coachIndex).displayCustomerAccrodingName();
                                            System.out.print("Do you want to show the details of another customer (Y/N)? ");
                                            repeat = input.next().charAt(0);
                                        } while (repeat == 'y' || repeat == 'Y');
                                    }
                                    else if (choice == 4) { // To show a list of all his female/male customers.
                                        do {
                                            ourGym.getCoaches().get(coachIndex).displayCustomersAccrodingGender();
                                            System.out.println("Do you want to show the customers of the other gender (Y/N)?");
                                            repeat = input.next().charAt(0);
                                        } while (repeat == 'y' || repeat == 'Y');
                                    }
    //                                else if (choice==5) {
    //                                    main();
    //                                }
                                    else {
                                        invalidMsg();
                                        continue;
                                    }
                                    while (true) {
                                        System.out.println("""
                                                Press:
                                                ------
                                                1 --> To do another operation.
                                                2 --> To Log Out.
                                                -------------------------------""");
                                        choice = input.nextInt();
                                        if (choice == 1) { // To do another operation.
                                            break;
                                        } else if (choice == 2) { // To Log Out.
                                            ourGym.logOut();
                                            break;
                                        } else {
                                            Main.invalidMsg();
                                            continue;
                                        }
                                    }
                                    if (choice == 1){
                                        continue;
                                    }
                                    else{
                                        break;
                                    }
                                }
    //                            break;
                            }
                            else {
                                ourGym.signUpCoach();
                                continue;
                            }
                        }
                        do {
                            System.out.println("""
                                    Press:
                                    ------
                                    1 --> To do another operation.
                                    2 --> To Log Out.
                                    -------------------------------""");
                            choice = input.nextInt();
                            if (choice == 1) { // To do another operation.
                                break;
                            }
                            else if (choice == 2) { // To Log Out.
                                ourGym.logOut();
                                break;
                            }
                            else {
                                invalidMsg();
                                continue;
                            }
                        } while (true);
                        if (choice==2){
                            break;
                        }
                    }
                    else if (choice==3) {
                        break;
                    }
                }
//                System.out.print("Do you want to Exit from the Our Gym (Y/N)? ");
//                repeat = input.next().charAt(0);
//                if (repeat!='y'&& repeat!='Y'){
//                    continue;
//                }
//                else {
//                    ourGym.logOut();
//                    break;
//                }
            }
            else if (choice == 3) { // If the user is a Customer.
                while (true) {
                    boolean login2 = false;
                    System.out.println("""
                            Press:
                            ------
                            1 --> To Sign Up, if you do not have an account.
                            2 --> To Log In, if you already have an account.
                            3 --> Back.
                            -------------------------------------------------""");
                    choice= input.nextInt();
                    if (choice==1){
                        ourGym.signUpCustomer();
                        login2 = true;
                    }
                    else if (choice == 2 || login2) {
                        int customerIndex = ourGym.logInCustomer();
                        if(ourGym.getCustomers().get(customerIndex).getSubscriptions().size()==0){
                            System.out.println("You have to subsrcibe first!");
                            System.out.println("-------------------------------------------------");
                            ourGym.getCustomers().get(customerIndex).addSubscription(ourGym.getCoaches());
                            ourGym.getCustomers().get(customerIndex).addInBody();
                        }
                        if (customerIndex != -1&& ourGym.getCustomers().get(customerIndex).getSubscriptions().size()!=0) {
                            while (true) {
                                System.out.println("""
                                    Press:
                                    ------
                                    1 --> To show your Coach information.
                                    2 --> To show Equipment.
                                    3 --> To show your Membership Plan details.
                                    4 --> To show your In-Body details.
                                    5 --> To know the kilos that you need to be reduced.
                                    -----------------------------------------------------""");
                                choice = input.nextInt();
                                if (choice == 1) { // To show your Coach information.
                                    ourGym.getCustomers().get(customerIndex).displayCoachInfo(ourGym.getCoaches());
                                }
                                else if (choice == 2) { // To show Equipment.
                                    ourGym.displayEquipment();
                                }
                                else if (choice == 3) { // To show your last Membership Plan details.
                                    ourGym.getCustomers().get(customerIndex).displayMembershipPlan();
                                }
                                else if (choice == 4) { //  To show your In-Body details at a specific date.
                                    do {
                                        ourGym.getCustomers().get(customerIndex).displayInBodyInfoAtDate();
                                        System.out.print("Do you want to show your In-Body in another date (Y/N)? ");
                                        repeat = input.next().charAt(0);
                                    } while (repeat == 'y' || repeat == 'Y');
                                }
                                else if (choice == 5) { // To know the kilos that you need to be reduced.
                                    ourGym.getCustomers().get(customerIndex).displayKilos();
                                }
                                else {
                                    invalidMsg();
                                    continue;
                                }
                                while (true) {
                                    System.out.println("""
                                        Press:
                                        ------
                                        1 --> To do another operation.
                                        2 --> To Log Out.
                                        -------------------------------""");
                                    choice = input.nextInt();
                                    if (choice == 1) { // To do another operation.
                                        break;
                                    }
                                    else if (choice == 2) { // To Log Out.
                                        ourGym.logOut();
                                        break;
                                    }
                                    else {
                                        Main.invalidMsg();
                                        continue;
                                    }
                                }
                                if (choice == 1){
                                    continue;
                                }
                                else{
                                    break;
                                }
                            }
                            break;
                        }

                        else {
                            ourGym.signUpCustomer();
                            continue;
                        }
                    }
                    else if(choice==3) {
                        break;
                    }
                    else {
                        invalidMsg();
                        continue;
                    }
                }
//                System.out.print("Do you want to Exit from the Our Gym (Y/N)? ");
//                repeat = input.next().charAt(0);
//                if (repeat!='y'&& repeat!='Y'){
//                    continue;
//                }
//                else {
//                    ourGym.logOut();
//                    break;
//                }
            }
            else{
                invalidMsg();
                continue;
            }
            System.out.print("Do you want to Exit from the Our Gym (Y/N)? ");
            repeat = input.next().charAt(0);
            if (repeat!='y'&& repeat!='Y'){
                continue;
            }
            else {
                ourGym.logOut();
                break;
            }
        }
    }
}