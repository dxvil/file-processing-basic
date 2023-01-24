package readers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomFileReaderTests {
    private final CustomFileReader customFileReader = new CustomFileReader();
    String pathToCsvFile = "src/main/java/file.csv";
    String pathToTextFile = "src/main/java/words.txt";
    String pathToEmptyCsvFile = "src/test/java/readers/empty.csv";
    String pathToEmptyTxtFile = "src/test/java/readers/empty.txt";

    @Test
    @DisplayName("Reading a csv file with Scanner and get a list with data from it")
    void readFileWithScannerCsvFile() throws Exception {
        ArrayList<String> result = customFileReader.readFileWithScanner(pathToCsvFile, ";");
        
        assertNotNull(result);
        assertTrue(result instanceof ArrayList);
        assertEquals(42, result.size());
    }

    @Test
    @DisplayName("Reading a text file with Scanner and get a list with data from it")
    void readFileWithScannerTextFile() throws Exception {
        ArrayList<String> result = customFileReader.readFileWithScanner(pathToTextFile, "\\n");
        
        assertNotNull(result);
        assertTrue(result instanceof ArrayList);
        assertEquals(69, result.size());
    }

    @Test
    @DisplayName("Reading an empty csv file")
    void readFileWithScannerEmptyCsvFile() throws Exception {
        ArrayList<String> result = customFileReader.readFileWithScanner(pathToEmptyCsvFile, ",");

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Reading an empty text file")
    void readFileWithScannerEmptyTextFile() throws Exception {
        ArrayList<String> result = customFileReader.readFileWithScanner(pathToEmptyTxtFile, ",");

        assertNotNull(result);
        assertEquals(0, result.size());
    }


    @Test
    @DisplayName("Reading a text file with read all lines and get a stream")
    void readFileWithStreamTxt() {
        List<String> result = customFileReader.readTextFile(pathToTextFile, "\\n");

        assertEquals(69, result.stream().collect(Collectors.toList()).size());
        assertNotNull(result);
        assertTrue(result instanceof List);
    }

    @Test
    @DisplayName("Reading an empty text file with read all lines and get a stream")
    void readFileWithStreamEmptyTxt() {
        List<String> result = customFileReader.readTextFile(pathToEmptyTxtFile, "\\n");

        assertEquals(0, result.stream().collect(Collectors.toList()).size());
        assertNotNull(result);
        assertTrue(result instanceof List);
    }
}
