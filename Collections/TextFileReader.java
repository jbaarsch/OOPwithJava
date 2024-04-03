package Collections;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
TextFileReader is an instantiated class will contain a file name path as instance data, and can return the contents of
the file at that location.  The class will also have static methods that can process a file.
 */
public class TextFileReader {

    private String fileName;


    public TextFileReader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner fileScan;
        try {
            fileScan = new Scanner(new File(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return lines;
        }
        // Read the file and add each line to the lines ArrayList
        while (fileScan.hasNext()) {
            lines.add(fileScan.nextLine());
        }
        return lines;
    }

    public static HashSet<String> getWords(String fileName, String delimiter) {
        String contents;

        try {
            contents = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);  // reads the file to a string.
        } catch (IOException e) {
            return new HashSet<String>();
        }

        List<String> wordList = List.of(contents.split(","));  // Splits the String into words using delimiter
        HashSet<String> words = new HashSet<String>();
        words.addAll(wordList);   // changes the List into a HashSet.
        return words;
    }
}
