package DatesAndTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarDemo {

    public static void main(String[] args) {

        // Calendar represents the abstraction of an instant in any given calendar
        // GregorianCalendar is a sub-class of Calendar and represents the Western Gregorian Calendar system.
        // Default constructor creates the calendar representing the current instant (down to milliseconds).
        Calendar calendar = new GregorianCalendar();

        // Default toString() method shows the class, and lists the instance variables and their values of the object.
        System.out.println(calendar);

// print out a bunch of interesting things
        System.out.println("ERA: " + calendar.get(Calendar.ERA));
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("DAY_OF_WEEK_IN_MONTH: "
                + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
        System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
        System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("ZONE_OFFSET: "
                + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
        System.out.println("DST_OFFSET: "
                + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));


        // Date favorite = new Date(2016, 10, 20);  // Nov 20, 2016
        Calendar favorite = new GregorianCalendar(2016, Calendar.NOVEMBER, 20);

        //Date leastFavorite = new Date(2004, 0, 23);  // Jan 23, 2004
        Calendar leastFavorite = new GregorianCalendar(2004, Calendar.JANUARY, 23);

        System.out.println("favorite date comes before least favorite date? " + favorite.before(leastFavorite));
        System.out.println("How many milliseconds since my least favorite date? " + ( (calendar.getTimeInMillis() -
                leastFavorite.getTimeInMillis())) );


        Calendar appointment = new GregorianCalendar(2004, 10, 23, 16, 15);
        System.out.println(appointment.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH));
        System.out.println(appointment.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH));

        String day = appointment.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
        String month = appointment.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);

        System.out.println(day + ", " + month + " " + appointment.get(Calendar.DAY_OF_MONTH) +
                " @" + appointment.get(Calendar.HOUR_OF_DAY) + ":" + appointment.get(Calendar.MINUTE) );


    }
}
