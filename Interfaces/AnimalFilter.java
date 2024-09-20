package Interfaces;


//  This class creates various filters related to Animal and its subclasses.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class AnimalFilter {

    public static Map<String, Predicate<Animal>> getAnimalFilters() {
        final int NUMBER_OF_FILTERS = 3;

        Map<String, Predicate<Animal>> filters = new HashMap<>();
        // S-Filter
        filters.put( "S-Dogs", getSDogFilter());
        // Long Names
        filters.put("Long Names", getLongNameFilter());
        // Four-Letter Words
        filters.put("4-Letter Words", animal -> animal.getName().length() == 4);

        return filters;
    }

    public static Predicate<Animal> getSDogFilter() {
        return (animal) -> { return animal.getName().startsWith("S")
                && animal instanceof Dog;} ;
    }

    public static Predicate<Animal> getLongNameFilter() {
        return animal -> animal.getName().length() >= 6;
    }







}
