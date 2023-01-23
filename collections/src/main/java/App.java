
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
        CustomFileReader csvFileReader = new CustomFileReader();
        Words<LinkedList<String>> wordsProcessingForLinkedList = new Words<>();

        Path pathToCsvFile = Paths.get("collections/src/main/java/file.csv");
        Path pathToTextFile = Paths.get("collections/src/main/java/words.txt");

        Stream<String> fileReadedFromScanner = csvFileReader.readFileWithScanner(pathToCsvFile.toString(), ";").stream();
    
        List<String> sortedFileReadedFromScanner = fileReadedFromScanner.sorted().collect(Collectors.toList());
    
       
        Stream<String> readedWords = csvFileReader.readTextFileWithStream(pathToTextFile.toString());
        List<String> words = readedWords.collect(Collectors.toList());
        LinkedList<String> wordsLinkedList = new LinkedList<>(words);

        
        System.out.println(wordsProcessingForLinkedList.countWords(wordsLinkedList));
        System.out.println(wordsProcessingForLinkedList.findLongestWord(wordsLinkedList));
    }
}
