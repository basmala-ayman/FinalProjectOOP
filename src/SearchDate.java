
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class SearchDate {

//    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    // Prase Date -> turn date from String to Date in format (dd-MM-yyyy)
    public static Date parseDate(String InputDate) {
        try {
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            return date.parse(InputDate);
        } catch (ParseException dateException) {
            throw new IllegalArgumentException("""
                                               Invalid date format!!
                                               Please, enter date in the format (dd-MM-yyyy): """);
        }
    }

    // Prase Date -> turn date from String to Date in format (MM-yyyy)
    public static Date parseDateMonth(String InputDate) {
        try {
            SimpleDateFormat date = new SimpleDateFormat("MM-yyyy");
            return date.parse(InputDate);
        } catch (ParseException dateException) {
            throw new IllegalArgumentException("""
                                               Invalid date format!!
                                               Please, enter date in the format (MM-yyyy): """);
        }
    }

//    public static void searchDay(Date[] dateArr, int searchDay) {
////        System.out.println("Dates with day " + searchDay + ":");
//        for (Date date : dateArr) {
//            int dayOfMonth = getDay(date);
//
//            if (dayOfMonth == searchDay) {
//                System.out.println(date);
//            }
//        }
//    }

//    public static Boolean searchMonth(Date date, int searchmonth) {
//
//        int Month = SearchDate.getMonth(date);
//
//        if (Month == searchmonth) {
//            return true;
//        }
//        return null;
//    }

    //    public static void searchMonth(Date[] dateArr, int searchmonth) {
////        System.out.println("Dates with month " + searchmonth + ":");
//        for (Date date : dateArr) {
//            int Month = getMonth(date);
//
//            if (Month == searchmonth) {
//                System.out.println(date);
//            }
//        }
//    }
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static long betweenDates(Date firstDate, Date secondDate) //throws IOException
    {
        return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
    }
    public static String getStringDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }
}