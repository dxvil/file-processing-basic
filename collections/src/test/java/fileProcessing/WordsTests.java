package fileProcessing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WordsTests {
    private final Words<List<String>> wordsProcessing = new Words<>();

    @Test
    @DisplayName("Find the longest word in a list")
    void findLongestWord1() {
        String[] listOfWords = {"abc", "aaaa", "aaaaa", "aaaaaaa", "dffddddddddddd"};
        List<String> list = List.of(listOfWords);

        String result = wordsProcessing.findLongestWord(list);
        
        assertEquals("dffddddddddddd", result);
    }

    @Test
    @DisplayName("Find the longest word in a list")
    void findLongestWord2() {
        String[] listOfWords = {
            "Supercalifragilisticexpialidocious",
            "Honorificabilitudinitatibus",
            "Pneumonoultramicroscopicsilicovolcanoconiosis",
            "Lopado­temacho­selacho­galeo­kranio­leipsano­drim­hypo­trimmato­silphio­karabo­melito­katakechy­meno­kichl­epi­kossypho­phatto­perister­alektryon­opte­kephallio­kigklo­peleio­lagoio­siraio­baphe­tragano­pterygon"
        };
        String longestOne = listOfWords[3];

        List<String> list = List.of(listOfWords);

        String result = wordsProcessing.findLongestWord(list);
        
        assertEquals(longestOne, result);
    }

    @Test
    @DisplayName("Count amount of times the word is repeating in list")
    void countWords() {
        List<String> list = List.of("apple", "apple", "apple", "orange", "orange", "banana");

        HashMap<String, Integer> result = wordsProcessing.countWords(list);


        String apple = list.get(0);
        String orange = list.get(3);
        String banana = list.get(5);

        assertEquals(3, result.get(apple));
        assertEquals(2, result.get(orange));
        assertEquals(1, result.get(banana));
    }

    @Test
    @DisplayName("Count amount of times the word is repeating with empry list")
    void countWordsWithEmptyList() {
        List<String> list = List.of();

        HashMap<String, Integer> result = wordsProcessing.countWords(list);

        assertEquals(0, result.size());
    }
}
