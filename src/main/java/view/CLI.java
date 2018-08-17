package view;

import models.TextStatistics;
import analyzer.TextAnalyzer;
import java.util.*;

public class CLI {

    /**
     * main метод, ожидает строку ввода из консоли,
     * затем анализирует введенный текст и обрабатывает результат.
     */
    public static void main(String[] args) {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        TextStatistics textStatistics;

        final String FULL = "--full";
        final String CHAR = "--char";
        final String WORD = "--word";
        final String HELP = "--help";
        final String QUIT = "--quit";

        final int KEY_LENGTH = 6;

        boolean runAnalyze = true;

        while (runAnalyze) {

            final String inputStream = getInputText();

            int index = inputStream.length() <= KEY_LENGTH ? inputStream.length() : KEY_LENGTH;

            final String key = inputStream.substring(0, index);

            switch (key) {
                case FULL:
                    if (inputStream.length() <= KEY_LENGTH) {
                        System.out.println(help());
                        break;
                    }
                    textStatistics = textAnalyzer.getTextStatistics(inputStream);
                    System.out.println(textStatistics.toString());
                    break;

                case CHAR:
                    if (inputStream.length() <= KEY_LENGTH) {
                        System.out.println(help());
                        break;
                    }
                    textStatistics = textAnalyzer.getCharTextStatistics(inputStream.substring(KEY_LENGTH + 1));
                    System.out.println(textStatistics.toStringChar());
                    break;
                case WORD:
                    if (inputStream.length() <= KEY_LENGTH) {
                        System.out.println(help());
                        break;
                    }
                    textStatistics = textAnalyzer.getWordTextStatistics(inputStream.substring(KEY_LENGTH + 1));
                    System.out.println(textStatistics.toStringWord());
                    break;
                case HELP:
                    System.out.println(help());
                    break;
                case QUIT:
                    runAnalyze = false;
                    break;
                default:
                    System.out.println(help());
                    break;
            }
        }
    }

    /**
     * Метод парсит входящий поток данных, пока из консоли, в дальнейшем может быть по другому
     * @return - строку с клавиатуры.
     */
    private static String getInputText() {
        System.out.println("TextAnalyzer_>");
        System.out.println("input key and text:");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * формирует строку помощи.
     */
    private static String help() {

        return  "\n" +
                "usage:\n\n" +
                "--help, print help\n" +
                "\n" +
                "--full <string> analyze & print oll available statistic" +
                "--char <string>  print only char statistics\n" +
                "--word <string>  print only word statistics\n" +
                "--quit, end program\n\n";
    }
}
