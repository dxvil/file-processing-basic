package readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class CustomFileReader {

    public Stream<String> readFileWithStream(String path) {
        Stream<String> stream = null;
        try {
            Path filePath = Paths.get(path);
            stream = Files.readAllLines(filePath).stream();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return stream;
    }

    public ArrayList<String> readFileWithScanner(String path, String delimiter) throws Exception {
        ArrayList<String> csvFileByWord = new ArrayList<>();

        Scanner reader = null;
        try {
            File fileToRead = new File(path);
            System.out.println(fileToRead.exists());
            reader = new Scanner(fileToRead).useDelimiter(delimiter);
    
            while(reader.hasNext()) {
                String word = reader.next();
                csvFileByWord.add(word);
            }

        } catch (FileNotFoundException ex) {
            throw new Exception("File is not found. Please, check a path of file");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            reader.close();
        }

        return csvFileByWord;
    }
}