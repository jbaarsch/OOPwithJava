package Streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntro {

    public static void main(String[] args) throws IOException {

        String contents = Files.readString(Path.of("ParadiseLost.txt"), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));

        // Iteration.
        long countIter = 0;
        for (String word : words) {
            if (word.length() > 12) {
                countIter++;
            }
        }

        //Streams
        long countStream = words.stream()
                .filter(w -> w.length() > 12)
                .count();

        ArrayList<String> badWords = new ArrayList<>(List.of("sex", "drugs", "C++"));

        ArrayList<Character> vowels = new ArrayList<>(List.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        words.stream()
                .filter(badWords::contains)
                .filter( w -> {
                    return vowels.contains(w.charAt(0));
                })
                .forEach(System.out::println);

        Stream<Integer> wordCounts = words.stream()
                .map( w -> w.length());

        int sum = 0;
        sum = words.stream()
                .map( w -> w.length())
                .reduce( 0, (subtotal, n)  -> subtotal + n);
        // can be shortened further .reduce(0, Integer::sum);

        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
        System.out.println("Largest: " + largest);



    }



}
