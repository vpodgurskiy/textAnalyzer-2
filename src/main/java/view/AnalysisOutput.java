package view;

import analyzeModel.ITextStatistics;

public class AnalysisOutput {
    /**
     * Метод выводит статистику анализа на экран.
     * На вход принимает статистику анализа (analyzeModel.TextStatistics)
     *
     * @param textStatistics - итоговый анализ текста.
     */
    public static void textPrinter(final ITextStatistics textStatistics) {
        System.out.println(textStatistics.toString());
    }
}
