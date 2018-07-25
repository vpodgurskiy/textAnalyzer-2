package analyzeModel;

import java.util.TreeMap;

public class WordStatistics implements ITextStatistics{

    private TreeMap<Character, Integer> numberOfCharacters;
    private TreeMap<String, Integer> numberOfWords;

    /**
     * Метод возвращает значение поля numberOfCharacters
     * @return numberOfCharacters
     */
    public TreeMap<Character, Integer> getNumberOfCharacters() {
        return numberOfCharacters;
    }

    /**
     * Метод возвращает значение поля numberOfWords
     * @return numberOfWords
     */
    public TreeMap<String, Integer> getNumberOfWords() {
        return numberOfWords;
    }

    /**
     * Конструктор структуры анализа.
     * @param numberOfWords количество встречающихся слов
     * @param numberOfCharacters количество встречающихся букв
     */
    public WordStatistics(final TreeMap<String, Integer> numberOfWords,
                          final TreeMap<Character, Integer> numberOfCharacters) {
        this.numberOfCharacters = numberOfCharacters;
        this.numberOfWords = numberOfWords;
    }

    /**
     * Переопределенный метод, формирует строку вывода в консоль
     * @return str
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n")
                .append(String.format("Количество встречающихся букв: %s\n", this.getNumberOfCharacters()))
                .append(String.format("Количество встречающихся слов: %s\n", this.getNumberOfWords()))
                .append("\n");

        return stringBuilder.toString();
    }
}
