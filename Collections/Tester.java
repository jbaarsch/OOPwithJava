package Collections;

import java.util.HashSet;
import java.util.List;

public class Tester {

    public static void main(String[] args) {
        String fileName = "ParadiseLost.txt";
        String stopWordsFile = "stopWords.txt.";


        TextFileReader poemReader = new TextFileReader(fileName);
        HashSet<String> stopWords = TextFileReader.getWords(stopWordsFile, ",");

        for (String word : stopWords)
            System.out.println(word);

        List<String> lines = poemReader.getLines();
        for (String line : lines)
            System.out.println(line);






    }
}
