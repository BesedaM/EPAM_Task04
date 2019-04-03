package by.epam.javatraining.beseda.task04.model.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Beseda
 * @version 1.0 28/03/2019
 */
public class TextFileReader {

    public static final String FILE_PATH
            = "C:\\Users\\User\\Documents\\NetBeansProjects\\EPAM_04";

    public static String readFile(String fileName) {
        String temp;
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader
                = new BufferedReader(
                        new FileReader(new File(FILE_PATH, fileName)))) {
            while ((temp = reader.readLine()) != null) {
                sb.append(temp).append("\n");
            }
        } catch (IOException ex) {
            return sb.toString();
        }
        return sb.toString();
    }

}
