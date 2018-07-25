package view;

import analyzeModel.CharStatistics;
import analyzeModel.ITextStatistics;
import analyzeModel.TextStatistics;
import analyzeModel.WordStatistics;
import analyzer.CharTextAnalyzer;
import analyzer.TextAnalyzer;
import analyzer.WordTextAnalyzer;
import parser.CommandLineParser;
import parser.Options;

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
        final String InputStream = in.nextLine();

        CommandLineParser parser = new CommandLineParser();
        Options options = parser.parse(InputStream);

        ITextStatistics textStatistics = null;

        if (options.hasKey("--h")) {
            Helper.printHelp();
            return;
        } else if (options.hasKey("--char")) {
            final String textForAnalyze = options.getValueOf("--char");
            CharTextAnalyzer textAnalyzer = new CharTextAnalyzer();
            textStatistics = textAnalyzer.parse(textForAnalyze);
        } else if (options.hasKey("--word")) {
            final String textForAnalyze = options.getValueOf("--word");
            WordTextAnalyzer textAnalyzer = new WordTextAnalyzer();
            textStatistics = textAnalyzer.parse(textForAnalyze);
        } else {
            final String textForAnalyze = InputStream;
            TextAnalyzer textAnalyzer = new TextAnalyzer();
            textStatistics = textAnalyzer.parse(textForAnalyze);
        }

        AnalysisOutput.textPrinter(textStatistics);
    }
}
