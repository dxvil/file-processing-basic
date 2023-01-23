package fileProcessing;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Words<T extends List<String>> {
    String theLongestWord = "";

    private String getTheLongestWord() {
        return this.theLongestWord;
    }

    private void setTheLongestWord(String word) {
        this.theLongestWord = word;
    }

    private void singleWordCount(HashMap<String, Integer> list, String word) {
        if(list.containsKey(word)) {
            list.put(word, list.get(word) + 1);
        } else {
            list.put(word, 1);
        }
    }

    public HashMap<String, Integer> countWords(T list) {
        HashMap<String, Integer> wordsCountStatistic = new HashMap<>();

        Stream<String> streamList = list.stream();
        streamList.forEach(word -> singleWordCount(wordsCountStatistic, word));

        return wordsCountStatistic;
    }
    
    public String findLongestWord(T list) {
        Stream<String> streamList = list.stream();
        streamList.forEach(word -> {
            if(word.length() > theLongestWord.length()) {
                  setTheLongestWord(word);
            }
        });
        return getTheLongestWord();
    }
}
