package analyzer;

import analyzeModel.WordStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class WordTextAnalyzer implements ITextAnalyzer {

    public WordStatistics parse(String text) {
        final TreeMap<Character, Integer> numberOfCharacters = numberOfCharacters(text);
        final TreeMap<String, Integer> numberOfWords = numberOfWords(text);

        return new WordStatistics(numberOfWords, numberOfCharacters);
    }

    /**
     * Метод на вход принимает техт, возвращает сортированный по ключам map.
     * Метод подсчитывает колличество букв, в тексте, заглавные или сторчные как одна.
     * @param text
     * @return сортированный map
     */
    private TreeMap<Character, Integer> numberOfCharacters(String text) {
        char[] textArr = text.toCharArray();
        List<Character> charArr = new ArrayList<Character>();
        for (char i : textArr) {
            if (Character.isLetter(i)) {
                charArr.add(Character.toLowerCase(i));
            }
        }
        TreeMap<Character, Integer> charUnique = new TreeMap<Character, Integer>();

        for (char i : charArr) {
            if (charUnique.containsKey(i)) {
                Integer value = charUnique.get(i);
                charUnique.put(i, ++value);
                continue;
            }
            charUnique.put(i, 1);
        }
        return charUnique;
    }

    /**
     * Метод принимает на вход текст, подсчитывает кол-во каждого слова в тексте.
     * Метод возвращает сортированный map. Слово и кол-во этого слова в тексте.
     * @param text
     * @return сортированный map
     */
    private TreeMap<String, Integer> numberOfWords(String text) {
        char[] textArr = text.toCharArray();
        List<Character> charArr = new ArrayList<Character>();
        for (char i : textArr) {
            if (Character.isLetter(i) || Character.isWhitespace(i)) {
                charArr.add(Character.toLowerCase(i));
            } else {
                charArr.add(' ');
            }
        }

        String str = "";
        for (int i = 0; i < charArr.size(); i++) {
            str += charArr.toString().join("", String.valueOf(charArr.get(i)));

        }
        String[] strArr = str.split(" ");

        TreeMap<String, Integer> wordUnique = new TreeMap<String, Integer>();

        for (String i : strArr) {
            if (i.isEmpty()) continue;
            if (wordUnique.containsKey(i)) {
                Integer value = wordUnique.get(i);
                wordUnique.put(i, ++value);
                continue;
            }
            wordUnique.put(i, 1);
        }
        return wordUnique;
    }
}
