package analyzer;

import models.TextStatistics;
import org.junit.Test;
import java.util.TreeMap;
import static org.assertj.core.api.Assertions.*;

public class TextAnalyzerTest {

    /**
     * Тест проверяет полный анализ заданой строки
     */
    @Test
    public void textParser() {

        final String textForAnalyze = "раз, два, раЗ, три-четыре! Раз дВВа";

        final TextStatistics textStatistics = new TextAnalyzer().getTextStatistics(textForAnalyze);

        final int expectedTotalChar = 35;
        final int expectedTotalCharWithoutSpaces = 30;

        TreeMap<String, Integer> expectedNumberOfWords =  new TreeMap<>();
        expectedNumberOfWords.put("раз", 3);
        expectedNumberOfWords.put("два", 1);
        expectedNumberOfWords.put("три", 1);
        expectedNumberOfWords.put("четыре", 1);
        expectedNumberOfWords.put("двва", 1);

        TreeMap<Character, Integer> expectedNumberOfCharacters =  new TreeMap<>();
        expectedNumberOfCharacters.put('р', 5);
        expectedNumberOfCharacters.put('д', 2);
        expectedNumberOfCharacters.put('а', 5);
        expectedNumberOfCharacters.put('в', 3);
        expectedNumberOfCharacters.put('з', 3);
        expectedNumberOfCharacters.put('т', 2);
        expectedNumberOfCharacters.put('и', 1);
        expectedNumberOfCharacters.put('ч', 1);
        expectedNumberOfCharacters.put('е', 2);
        expectedNumberOfCharacters.put('ы', 1);

        assertThat(textStatistics.getTotalChar()).isEqualTo(expectedTotalChar);
        assertThat(textStatistics.getTotalCharWithoutSpaces()).isEqualTo(expectedTotalCharWithoutSpaces);
        assertThat(textStatistics.getNumberOfWords()).isEqualTo(expectedNumberOfWords);
        assertThat(textStatistics.getNumberOfCharacters()).isEqualTo(expectedNumberOfCharacters);
    }
}