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


        boolean runAnalyze = true;

        while (runAnalyze) {
            /**
             * не стоит создавать отдельные переменные, если они будут использованы только один раз!
             * Проще сразу передать результат работы метода куда следует.
             */
            Options options = parseParams(getInputText());

            /***
             * Вот почему бы не убрать эти if else в switch?????
             */
            if (InputKeys.help.equals(options.getInputKey())) {
                Helper.printHelp();
                continue;
            }else if (InputKeys.quit.equals(options.getInputKey())) {
                runAnalyze = false;
                continue;
            }

            /**
             * Я урезал пару строк. Упростил запись.
             * Поскольку мы еще не пишем в файл - класс AnalysisOutput не нужен.
             * Все равно  она не рисует красивые таблички и т.п.
             * А вот потом уже, если нужно - добавим класс записи в файл, а может и просто строку.
             * Но это сильно потом.!!!!!!!!!!!
             * Давай пока файлы не трогать.
             * Нужно довести этот этап до красоты, а потом модернизировать под новые задачи.
             */
            System.out.println(analyzeText(options));
        }
    }

    private static TextStatistics analyzeText(Options options) {

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        TextStatistics textStatistics;

        InputKeys inputKey = options.getInputKey();
        String inputArgument = options.getInputArgument();
/***
 * Это же наше меню. Но почему в него не входят quit и help?
 * Выйти из игры у меня так и не получилось. В хелпе об этом ничего не сказано.
 *
 * Вообще, на данном этапе, думаю стоит НЕ выносить менюшку в отдельный метод.
 * Был-бы switch внутри while. Впринципе так и есть. Но как-то не рационально.
 */
        switch (inputKey) {
            case chr:
                textStatistics = textAnalyzer.getCharTextStatistics(inputArgument);
                break;
            case word:
                textStatistics = textAnalyzer.getWordTextStatistics(inputArgument);
                break;
            /***
             * Я понимаю, что ты тут решил вставить полный анализ.
             * Но лучше это сделать неким boolean в Options и если нет никаких ключей - то пускай идет
             * полный анализ отдельным кейсом, а default пускай лучше выводит хелп в результате неверного ввода ключа.
             * Еще думаю, что можно просто ввести ключь для полного анализа. И указать это в хелпе.
             * И тогда ввод текста без ключа - будет выводить хелп - типа прога не понимает что именно от нее хотят )))
             *
             */
            case deflt: default:
                textStatistics = textAnalyzer.getTextStatistics(inputArgument);
                break;
        }
        return textStatistics;
    }

    //не уверен, что ради одной строки стоит целый метод создавать.
    //Эта строка будет сильно меняться? У нас же статически все тут делается.
    private static Options parseParams(String inputStream) {
        return new CommandLineParser().parse(inputStream);
    }

    //Хорошо, что в отдельном методе. Мало-ли как поменяется способ приема текста.
    //Он будет не только из строки но и из других источников.
    private static String getInputText() {
        System.out.printf("TextAnalyzer_>");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
