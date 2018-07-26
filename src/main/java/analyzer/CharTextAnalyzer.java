package analyzer;

import analyzeModel.CharStatistics;

public class CharTextAnalyzer implements ITextAnalyzer{

    public CharStatistics parse(String text) {
        final int totalChar = TextAnalyzer.totalChar(text);
        final int totalCharWithoutSpaces = TextAnalyzer.totalCharWithoutSpaces(text);

        return new CharStatistics(totalChar, totalCharWithoutSpaces);
    }
}
