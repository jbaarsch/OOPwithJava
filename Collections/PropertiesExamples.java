package Collections;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesExamples {

    private static final String TEXT_DIRECTORY = "text_files/";
    public static void main(String[] args) throws IOException {

       // Logger logger = Logger.getLogger("OOPWithJava.Collections");
       // var handler = new FileHandler("PropertiesExample", true);

        String path = "properties";

        var settings = new Properties();
        settings.put("width", "200");
        settings.put("title", "Hello, World!");
        try (OutputStream out = Files.newOutputStream(Path.of(path))) {
             settings.store(out, "Program Properties");
        }


        Properties myProperties = System.getProperties();

        for (Object oKey : myProperties.keySet()) {
            String key = (String) oKey;
            System.out.println(key + ": \t" + myProperties.getProperty(key));
        }




    }


}
