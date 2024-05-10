package Collections;

import java.util.*;

public class Tester {

    public static final String TEXT_DIRECTORY = "text_files/";
    public static void main(String[] args) {
        String fileName = TEXT_DIRECTORY + "ParadiseLost.txt";
        String stopWordsFile = TEXT_DIRECTORY + "stopWords.txt.";


        TextFileReader poemReader = new TextFileReader(fileName);
        HashSet<String> stopWords = TextFileReader.getWords(stopWordsFile, ",");

        //for (String word : stopWords)
            //System.out.println(word);

        List<String> lines = poemReader.getLines();
        //for (String line : lines)
            //System.out.println(line);


        bizzarroIteratorBehavior();
    }

    public static void bizzarroIteratorBehavior() {
        List<String> words = new ArrayList<>();
        words.addAll(List.of(new String[] {"Apple", "Banana", "Cranberry", "Grape", "Ham"}));

        ListIterator<String> cursor = words.listIterator();



        System.out.println(cursor.next());
        System.out.println(cursor.next());
        System.out.println(cursor.next());
        cursor.remove();
        cursor.add("Donut");
        cursor.add("Eggplant");
        cursor.add("Fudge");
        cursor.add("Fudge");
        //cursor.remove();
        System.out.println(cursor.next());
        System.out.println(cursor.next());

        System.out.println();
        for (String food : words)
            System.out.println(food);



    }








}
