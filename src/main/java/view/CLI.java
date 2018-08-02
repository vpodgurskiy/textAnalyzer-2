package view;

import models.TextStatistics;
import analyzer.TextAnalyzer;
import parser.CommandLineParser;
import models.InputKeys;
import models.Options;
import java.util.*;

public class CLI {

    /**
     * main метод, ожидает строку ввода из консоли,
     * затем анализирует введенный текст и обрабатывает результат.
     * @param args
     */
    public static void main(String[] args) {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        TextStatistics textStatistics;

        boolean runAnalyze = true;

        while (runAnalyze) {

            Options options = new CommandLineParser().parse(getInputText());
            InputKeys inputKey = options.getInputKey();
            String inputArgument = options.getInputArgument();

            switch (inputKey.getNumVal()) {
                case 1:
                    Helper.printHelp();
                    break;
                case 2:
                    runAnalyze = false;
                    break;
                case 3:
                    textStatistics = textAnalyzer.getCharTextStatistics(inputArgument);
                    System.out.println(textStatistics.toString());
                    break;
                case 4:
                    textStatistics = textAnalyzer.getWordTextStatistics(inputArgument);
                    System.out.println(textStatistics.toString());
                    break;
                default:
                    textStatistics = textAnalyzer.getTextStatistics(inputArgument);
                    System.out.println(textStatistics.toString());
                    break;
            }
        }
    }

    /**
     * Метод парсит входящий поток данных, пока из консоли, в дальнейшем может быть по другому
     * @return
     */
    private static String getInputText() {
        System.out.printf("TextAnalyzer_>");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
