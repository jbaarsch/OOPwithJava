package DatesAndTime;

//import javax.xml.datatype.Duration;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;

public class JavaTimeDemo {

    public static void main(String[] args) {

        // LocalDate represents a day.  The time objects are immutable, and the standard here is to use functions to
        // create them rather than constructors.  So, LocalTime.now() gets the current date
        LocalDate localDate = LocalDate.now();
        // LocalTime represents a time.  now is....now.
        LocalTime localTime = LocalTime.now();

        // Use LocalDateTime for a moment that represents the date and time together.
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // time objects are immutable.  So, rather than change the attribute of localDateTime, this returns a new
        // LocalDateTime object with a different dayOfMonth attribute.  The localDateTime object remains unchanged.
        System.out.println(localDateTime.withDayOfMonth(19));

        // time API has multiple new abstractions--including Month and DayOfWeek.
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        // prints out the name of the dayOfWeek (all caps)
        System.out.println(dayOfWeek);
        System.out.println(dayOfWeek.name());
        // Display name will only capitalize first letter--and you can get abbreviated versions or versions
        // that apply to other Locales.
        System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, Locale.GERMANY));


        // Date favorite = new Date(2016, 10, 20);  // Nov 20, 2016
        //Calendar favorite = new GregorianCalendar(2016, Calendar.NOVEMBER, 20);
        LocalDate favorite = LocalDate.of(2016, 11, 20);

        //Date leastFavorite = new Date(2004, 0, 23);  // Jan 23, 2004
        //Calendar leastFavorite = new GregorianCalendar(2004, Calendar.JANUARY, 23);
        LocalDate leastFavorite = LocalDate.of(2004, 1, 23);

        // Time API uses the more standard isBefore syntax for returning a boolean than before
        System.out.println("favorite date comes before least favorite date? " + favorite.isBefore(leastFavorite));

        // Time API has Period for representing large times between two localDates
        System.out.println("How many years since my least favorite date? " +
                ( Period.between(leastFavorite, localDate).getYears()) + " years");


        LocalDateTime appointment = LocalDateTime.of(2004, 11, 23, 16, 15);
        System.out.println(appointment.format(DateTimeFormatter.ISO_DATE_TIME));

        String day = appointment.getDayOfWeek().name();
        String month = appointment.getMonth().name();

        System.out.println(day + ", " + month + " " + appointment.getDayOfMonth() +
                " @" + appointment.getHour() + ":" + appointment.getMinute() );

        // Time API has Duration to represent periods of time between two times.  Also, clearer functions for adding
        // standard units of time to other times.
        // !!!!!! NOTE:  There is a Duration class in javax.xml.datatype.  IntelliJ may try to import that Duration and
        // use it instead--this will cause problems.  Remove that import statement if it appears.
        LocalTime startTime = LocalTime.of(4, 0);
        //LocalTime endTime = startTime.plusHours(1);
        //LocalTime endTime = LocalTime.of(5, 0);
        LocalTime endTime = startTime.plus(Duration.ofMinutes(60));
        Duration length = Duration.between(startTime, endTime);
        System.out.println(length.toMinutes());
    }
}
