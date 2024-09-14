package DatesAndTime;

import java.util.Date;
// Note MOST of the functions in Date have been deprecated since Java 1.1, because they were poorly designed.
// Date was replaced by Calendar.
// Calendar has since been replaced by the java.time API
// Discussions about this abound on the web.  Here is one:
// https://codeblog.jonskeet.uk/2017/04/23/all-about-java-util-date/



public class DateDemo {
    public static void main(String[] args) {

        // Date uses the Unix epoch--Jan 1, 1970, midnight at the start of the day (GMT)

        //  Time in the day is defaulted to 0.
        Date now = new Date(2024, 8, 14);

        System.out.println(now);
        System.out.println(now.toGMTString());
        System.out.println(now.toLocaleString());
        System.out.println(now.getTime());     // returns the timestamp in milliseconds--milliseconds since the epoch
        System.out.println(now.getYear());      // returns the year
        System.out.println(now.getMonth());      // returns month--but months are stored 0 - 11
        System.out.println(now.getDate());      // returns the day of the month
        System.out.println(now.getDay());       // returns day of week?  sort of?
        System.out.println(now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());
        now.setHours(8);
        now.setMinutes(53);
        now.setSeconds(23);
        // will remember hours, minutes, and seconds for that date
        System.out.println(now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds());

        Date favorite = new Date(2016, 10, 20);  // Nov 20, 2016
        Date leastFavorite = new Date(2004, 0, 23);  // Jan 23, 2004

        System.out.println("favorite date comes before least favorite date? " + favorite.before(leastFavorite));
        System.out.println("How many milliseconds since my least favorite date? " + ( (now.getTime() - leastFavorite.getTime())) );



    }

}
