package analyzer;

import analyzeModel.WordStatistics;
import java.util.TreeMap;

public class WordTextAnalyzer implements ITextAnalyzer {

    public WordStatistics parse(String text) {
        final TreeMap<Character, Integer> numberOfCharacters = TextAnalyzer.numberOfCharacters(text);
        final TreeMap<String, Integer> numberOfWords = TextAnalyzer.numberOfWords(text);

        return new WordStatistics(numberOfWords, numberOfCharacters);
    }
}
