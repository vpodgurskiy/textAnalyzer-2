package analyzer;

import analyzeModel.CharStatistics;

public class CharTextAnalyzer implements ITextAnalyzer{

    public CharStatistics parse(String text) {
        final int totalChar = totalChar(text);
        final int totalCharWithoutSpaces = totalCharWithoutSpaces(text);

        return new CharStatistics(totalChar, totalCharWithoutSpaces);
    }

    private int totalChar(String text) {
        final int totalChar = text.length();
        return totalChar;
    }

    /**
     * Метод на вход принимает текст, возвращает кол-во символов без пробелов
     * @param text
     * @return int
     */
    private int totalCharWithoutSpaces(String text) {
        String[] arr = text.split("");
        int totalCharWithoutSpaces = 0;
        for (String item : arr) {
            if (!" ".equals(item)) {
                totalCharWithoutSpaces += 1;
            }
        }
        return totalCharWithoutSpaces;
    }

}
