package readers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @DisplayName("Reading a csv file with read all lines and get a stream")
    void readFileWithStreamCsv() throws IllegalArgumentException {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> {
            customFileReader.readTextFileWithStream(pathToCsvFile);
        });

        assertEquals(
            "The file is csv extension, cannot cover with this method yet",
            thrown.getMessage()
        );
        
    }

    @Test
    @DisplayName("Reading a text file with read all lines and get a stream")
    void readFileWithStreamTxt() {
        Stream<String> result = customFileReader.readTextFileWithStream(pathToTextFile);

        assertEquals(69, result.collect(Collectors.toList()).size());
        assertNotNull(result);
        assertTrue(result instanceof Stream);
    }

    @Test
    @DisplayName("Reading an empty text file with read all lines and get a stream")
    void readFileWithStreamEmptyTxt() {
        Stream<String> result = customFileReader.readTextFileWithStream(pathToEmptyTxtFile);

        assertEquals(0, result.collect(Collectors.toList()).size());
        assertNotNull(result);
        assertTrue(result instanceof Stream);
    }
}
