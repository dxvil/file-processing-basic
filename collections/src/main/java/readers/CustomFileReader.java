package readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomFileReader {

    public List<String> readTextFile(String path, String delimiter) throws IllegalArgumentException {
        ArrayList<String> finalResult = new ArrayList<>();
        try {
            Path filePath = Paths.get(path);

            List<String> readedLines = Files.readAllLines(filePath);
            
            if(Files.lines(filePath).count() == readedLines.size() && (!readedLines.stream().anyMatch(str -> str.contains(delimiter)))) {
                return readedLines;
            } 

            for(String line:readedLines) {
                String[] words = line.split(delimiter);

                for(String word:words) {
                            finalResult.add(word);
                }
            }

            return finalResult;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return finalResult;
    }

    public ArrayList<String> readFileWithScanner(String path, String delimiter) throws Exception {
        ArrayList<String> csvFileByWord = new ArrayList<>();

        Scanner reader = null;
        try {
            File fileToRead = new File(path);
            
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
