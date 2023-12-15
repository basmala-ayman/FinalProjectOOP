

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Calendar;

public class MembershipPlan {

    private Date startDate;
    private int monthlyPlan;
    private int monthRegisterd;
    private float price;
//    private Date endDate;

    // Setters
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setMonthlyPlan(int monthlyPlan) {
        this.monthlyPlan = monthlyPlan;
    }

    public void setMonthRegisterd(int monthRegisterd) {
        this.monthRegisterd = monthRegisterd;
    }

    // Getters

    public Date getStartDate() {
        return startDate;
    }

    public int getMonthlyPlan() {
        return monthlyPlan;
    }

    public int getMonthRegisterd() {
        return monthRegisterd;
    }

    public float getPrice() {
        float finalPrice = calculateDiscount();
        return finalPrice;
    }

    // Prase Date -> turn date from String to Date
//    public static Date parseDate(String InputDate) {
//        try {
//            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
//            return date.parse(InputDate);
//        } catch (ParseException dateException) {
//            throw new IllegalArgumentException("""
//                                               Invalid date format!!
//                                               Please, enter date in the format (dd-mmm-yyyy): """);
//        }
//    }

    private float calculateDiscount() {
        float discount = 0.10f;
        if (monthlyPlan == 3) {
            price = 100 * monthRegisterd;
        } else {
            price = 200 * monthRegisterd;
        }
        if (monthRegisterd >= 3) {
            return (price - (price * discount));
        } else {
            return price;
        }
    }

    public Date getEndDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.startDate);
        calendar.add(Calendar.MONTH, this.monthRegisterd);
//        this.endDate = calendar.getTime();
        return calendar.getTime();
    }

    // displayInfo
    public void displayInfo() {
        System.out.println("Start date: " + SearchDate.getStringDate(startDate));
        System.out.println("Monthly plan: " + monthlyPlan + " per week");
        System.out.println("Months registered: " + monthRegisterd);
        float finalPrice = calculateDiscount();
        System.out.println("Price: " + finalPrice);
        System.out.println("End date: " + SearchDate.getStringDate(getEndDate()));
    }

}

