package Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

record Pair<S, T>(S first, T second) {}

record City(String name, String state, int population) {
}
public class CollectingStreamResults {


    public static void main(String[] args) throws IOException {

             // Demonstrates what toMap does if you have key conflicts.
        //languageNamesExample();

             // Demonstrates what happens if toMap has value conflicts.
        //countryLanguageExample();

            //  Demonstrates Grouping and partitioning
        //groupingWithMapsExample();

            //  Demonstrates Downstream Collectors.
        //reducingMapGroupsToValuesExample();


    }

    // Demonstrates what toMap does if you have key conflicts.
    public static void languageNamesExample() {
        // Generate a Stream of Locales
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        // Map name of language in my locale to the name of the language in its locale.  German to Deutsch, e.g.
        Map<String, String> languageNames = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayLanguage,     // the name of the language in my locale
                        loc -> loc.getDisplayLanguage(loc),   // the name of the language in the language's locale
                        (existingValue, newValue) -> existingValue  // what to do if there is a conflict of keys
                )
        );

        languageNames.forEach((k, v) -> System.out.println(k + ";\t" + v));
    }

    // Demonstrates what happens if toMap has value conflicts.
    public static void countryLanguageExample() {

        // Generate a Stream of Locales
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        // Map countries to languages spoken in that country.
        Map<String, Set<String>> countryLanguageSets = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,    // get country name for first part of map
                        l -> Collections.singleton(l.getDisplayLanguage()),   //get a set of the display language for value
                        (a, b) -> {                  // if there is a conflict, a is the old value, b is the new value.
                            var union = new HashSet<String>(a);      // make a a HashSet
                            union.addAll(b);                       // add all of b to a.
                            return union;
                        }
                )
        );

        countryLanguageSets.forEach( (k, v) -> { if (!k.isEmpty()) {
            System.out.println(k );
            v.forEach( vE -> System.out.println("\t" + vE));
            }
        });

    }

    public static void groupingWithMapsExample() {

        // Generate a Stream of Locales
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        // creates a map with all the country as the key and a list of the Locales in that country the value
                         //    /*
        Map<String, List<Locale>> countryToLocale = locales.collect(
                groupingBy(Locale::getCountry)
        );

        countryToLocale.get("CH")
            .forEach( l -> {
                System.out.print("\n" + l);
                System.out.print("\t" + l.getDisplayLanguage() + " _ " + l.getDisplayCountry());
        });


        System.out.println("\n\n");
                        //   */

                           /*
        // Partitions locales in terms of whether English is part or not.
        Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
                Collectors.partitioningBy( l -> l.getLanguage().equals("en"))
        );    // NOTE:  THROWS ILLEGAL STATE EXCEPTION!!!!  Since Stream has already been processed, cannot process again
        //  Some terminal operations are okay (forEach(print) is fine ), others will create this exception.

        List<Locale> englishLocales = englishAndOtherLocales.get(true);

        englishLocales.forEach( l -> {
            System.out.print("\n" + l);
            System.out.print("\t" + l.getDisplayLanguage() + " _ " + l.getDisplayCountry());
        });
                            */
    }

    public static void reducingMapGroupsToValuesExample() throws IOException {

        // Generate a Stream of Locales
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        // Generate Stream of Cities:
        Stream<City> cities = readCities("cities.txt");

        //countElements(locales);
        //collectAmounts(cities);
        //findMaxValue(cities);
        findTotalCityPop(cities);






    }

    public static void countElements(Stream<Locale> locales) {
        Map<String, Long> countryToLocaleCounts = locales.collect(
                groupingBy(Locale::getCountry, counting())
        );

        countryToLocaleCounts.forEach( (k, v) -> {
            System.out.println(k + ":\t" + v);
        });
    }

    public static void collectAmounts(Stream<City> cities) {
        Map<String, Integer> stateToCityPopulation = cities.collect(
                groupingBy(City::state,
                        summingInt(City::population))
        );

        stateToCityPopulation.forEach( (k, v) -> {
            System.out.println(k + ":\t" + v);
        });
    }

    public static void findMaxValue(Stream<City> cities) {
                              //  /*
        Map<String, Optional<City>> stateToLargestCity = cities.collect(
                groupingBy(City::state,
                        maxBy(Comparator.comparing(City::population)))
        );

        stateToLargestCity.forEach( (k, v) -> {
            System.out.print("\n" + k + ":\t");
            v.ifPresent(
                    c -> System.out.print(c.name()));
        });
                                 //   */
                                    /*
        //Alternatively, apply an additional processing step to the end.
        // This will apply maxBy to the string city Name, not the City type itself.
        Map<String, Optional<String>> stateToLargestCity = cities.collect(
                groupingBy(City::state,
                        mapping(City::name,
                            maxBy(Comparator.comparing(String::length))
                        )
                )
        );

        stateToLargestCity.forEach( (k, v) -> {
            System.out.print("\n" + k + ":\t");
            v.ifPresent(System.out::print);
        });
                                 */
    }

    public static void findTotalCityPop(Stream<City> cities) {
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(
                groupingBy(City::state,
                        summarizingInt(City::population)
                )
        );

        stateToCityPopulationSummary.forEach( (k, v) -> {
            System.out.print("\n" + k + ":\n");
            System.out.println("\tcount:\t" + v.getCount());
            System.out.println("\tsum:\t" + v.getSum());
            System.out.println("\tavg:\t" + v.getAverage());
            System.out.println("\tmin:\t" + v.getMin());
            System.out.println("\tmax:\t" + v.getMax());
        });

    }

    public static Stream<City> readCities(String filename) throws IOException {
        return Files.lines(Path.of(filename)).map(l -> l.split(", ")).map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }


}
