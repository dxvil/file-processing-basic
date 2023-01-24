
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fileProcessing.Words;
import readers.CustomFileReader;

public class App {
    public static void main( String[] args ) throws Exception {
        CustomFileReader fileReader = new CustomFileReader();
        Words<LinkedList<String>> wordsProcessingForLinkedList = new Words<>();

        Path pathToCsvFile = Paths.get("collections/src/main/java/file.csv");
        Path pathToTextFile = Paths.get("collections/src/main/java/words.txt");

        Stream<String> fileReadedFromScanner = fileReader.readFileWithScanner(pathToCsvFile.toString(), ";").stream();
    
        List<String> sortedFileReadedFromScanner = fileReadedFromScanner.sorted().collect(Collectors.toList());
    
        
        List<String> fileReadedText = fileReader.readTextFile(pathToTextFile.toString(), "\\n");
        List<String> fileReaded = fileReader.readTextFile(pathToCsvFile.toString(), ";");
        
        LinkedList<String> wordsLinkedList = new LinkedList<>(fileReaded);

        wordsProcessingForLinkedList.countWords(wordsLinkedList);
        
        fileReadedText.forEach(System.out::println);
        fileReaded.forEach(System.out::println);

        fileReadedFromScanner.close();
    }
}
