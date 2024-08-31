package Collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {

        // A HashMap is a generic class, like an ArrayList.  That is, it is a Collection of any particular Data Type
        // (except primitives).  The difference is that it is not a list, but a map.  That means it makes an association
        // between a key and a value.  When you declare your hash map, the first type in the angled brackets is the
        // key type, and the second is the value type.  (You will note that the type variable abbreviations are K for
        // Key and V for Value.
        HashMap<String, Date> birthdays = new HashMap<String, Date>();
        // This HashMap makes an association between strings and dates.  The name of the object (birthdays) suggests
        // that the dates will be birthdays.

        // Once the collection is created, it is time to add something to the map.
        // Since birthdays is a map between strings and dates, we will need a String object and a Date object to add
        // to the map.
        Date myBirthday = new Date(1960, 01, 01);
        String myName = "Josie Wales     ";

        // A collection of one isn't very interesting, so we will create another one here:
        Date yourBirthday = new Date(2001, 01, 01);
        String yourName = "Wild Bill Hickok";

        // To add your objects to the list, use the put method:
        birthdays.put(myName, myBirthday);
        birthdays.put(yourName, yourBirthday);
        // These commands added two new entries in the map, one associating the myName String with the myBirthday Date.
        // The second associating the yourName String with the yourBirthday Date.

        // There are many things you can do with these associations, but for now, the main use we have is to retrieve
        // the value associated with any given key.  We do this with the .get() method.  You can enter a key as the
        // parameter and the value will be returned.  The following gets the Date objects associated with each of the
        // two keys and prints them to the console.
        System.out.println(birthdays.get(myName));
        System.out.println(birthdays.get(yourName));

        // Another common operation on Maps, is to get all the entries and do something with them.  You can use an enhanced
        // for loop to retrieve each entry and then use the .getKey() fuction to get the key of that entry, and the
        // .getValue() function to return the value in that entry.  Here I print out the key and the value for each
        // entry in the HashMap.
        for (Map.Entry<String, Date> entry : birthdays.entrySet()) {
            System.out.println(entry.getKey() + " \t\t" + entry.getValue());
        }

        // Finally, let's talk about the difference between keys and values.  In the HashMap, every key is unique.  But
        // the values can be duplicated.  Moreover, you can change the value associated with each key.  So I can use the
        // put command again to change the Date object associated with myName to another Date.
        birthdays.put(myName, yourBirthday);
        // Now, when I access the date value associated with the myName key, I will get yourBirthday Date back.
        System.out.println(birthdays.get(myName));


    }



}
