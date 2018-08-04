package models;

import java.util.TreeMap;

public class TextStatistics {

    private int totalChar;
    private int totalCharWithoutSpaces;
    private TreeMap<Character, Integer> numberOfCharacters;
    private TreeMap<String, Integer> numberOfWords;

    /**
     * Метод возвращает значение поля totalChar
     * @return totalChar
     */
    public int getTotalChar() {
        return totalChar;
    }

    /**
     * Метод возвращает значение поля totalCharWithoutSpaces
     * @return totalCharWithoutSpaces
     */
    public int getTotalCharWithoutSpaces() {
        return totalCharWithoutSpaces;
    }

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
     * @param totalChar всего символов в тексте
     * @param totalCharWithoutSpaces всего символов без пробелов
     * @param numberOfCharacters количество встречающихся букв
     */
    public TextStatistics(final int totalChar, final int totalCharWithoutSpaces,
                          final TreeMap<Character, Integer> numberOfCharacters) {

        this(totalChar, totalCharWithoutSpaces, null, numberOfCharacters);
    }

    /**
     * Конструктор структуры анализа.
     * @param numberOfWords количество встречающихся слов
     */
    public TextStatistics(final TreeMap<String, Integer> numberOfWords) {
        this(0, 0, numberOfWords, null);
    }


    /**
     * Конструктор структуры анализа.
     * @param totalChar всего символов в тексте
     * @param totalCharWithoutSpaces всего символов без пробелов
     * @param numberOfWords количество встречающихся слов
     * @param numberOfCharacters количество встречающихся букв
     */
    public TextStatistics(final int totalChar, final int totalCharWithoutSpaces,
                          final TreeMap<String, Integer> numberOfWords,
                          final TreeMap<Character, Integer> numberOfCharacters) {

        this.totalChar = totalChar;
        this.totalCharWithoutSpaces = totalCharWithoutSpaces;
        this.numberOfWords = numberOfWords;
        this.numberOfCharacters = numberOfCharacters;
    }


    /**
     * Переопределенный метод, формирует строку вывода в консоль
     * @return str
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n")
                .append(String.format("Всего символов в тексте: %s\n", this.getTotalChar()))
                .append(String.format("Всего символов без пробелов: %s\n", this.getTotalCharWithoutSpaces()))
                .append(String.format("Количество встречающихся букв: %s\n", this.getNumberOfCharacters()))
                .append(String.format("Количество встречающихся слов: %s\n", this.getNumberOfWords()))
                .append("\n");

        return stringBuilder.toString();
    }

    public String toStringChar() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n")
                .append(String.format("Всего символов в тексте: %s\n", this.getTotalChar()))
                .append(String.format("Всего символов без пробелов: %s\n", this.getTotalCharWithoutSpaces()))
                .append(String.format("Количество встречающихся букв: %s\n", this.getNumberOfCharacters()))
                .append("\n");

        return stringBuilder.toString();
    }

    public String toStringWord() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n")
                .append(String.format("Количество встречающихся слов: %s\n", this.getNumberOfWords()))
                .append("\n");

        return stringBuilder.toString();
    }
}
