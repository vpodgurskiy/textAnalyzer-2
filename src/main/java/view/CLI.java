package view;

import analyzer.TextAnalyzer;

import java.util.*;

public class CLI {

    /**
     * main метод, ожидает строку ввода из консоли,
     * затем анализирует введенный текст и обрабатывает результат.
     * @param args
     */
    public static void main(String[] args) {
        System.out.printf("TextAnalyzer_>");
        Scanner in = new Scanner(System.in);
        final String textForAnalyze = in.nextLine();

        AnalysisOutput.textPrinter(TextAnalyzer.textParser(textForAnalyze));
    }
}
