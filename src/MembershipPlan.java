

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
        return calculateDiscount();
    }

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
        System.out.println("Price: " + calculateDiscount());
        System.out.println("End date: " + SearchDate.getStringDate(getEndDate()));
    }

}

