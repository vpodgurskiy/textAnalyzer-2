package parser;

import models.InputKeys;
import models.Options;

public class CommandLineParser {

    /**
     * Парсит входящий поток данных, получает из него ключи
     * и устанавливает значения ключей.
     * В дальнейшем можно добавить исходящий ключ (OutputKey),
     * а так же исходящий аргумент (OutputArgument) - например имя файла,
     * в который записать статистику анализа
     * @param inputStream
     * @return
     */
    public Options parse(final String inputStream) {

        Options options = new Options();

        //кстати не думал тут switch применить?
        //Вдруг хорошо станет?

        if (inputStream.contains("--char")) {
            options.setInputKey(InputKeys.chr);
            options.setInputArgument(inputStream.substring(7));
        } else if (inputStream.contains("--word")) {
            options.setInputKey(InputKeys.word);
            options.setInputArgument(inputStream.substring(7));
        } else if (inputStream.contains("--h")) {
            options.setInputKey(InputKeys.help);
            options.setInputArgument(help());
        } else if (inputStream.contains("--quit")) {
            options.setInputKey(InputKeys.quit);
        } else {
            options.setInputKey(InputKeys.full);
            options.setInputArgument(inputStream);
        }

        return options;
    }

    public static String help() {

        /**
         * формирует строку помощи.
         */
        return  "\n" +
                "usage:\n\n" +
                "--h, print help\n" +
                "<arg> print full statistics\n" +
                "--char <arg>  print only char statistics\n" +
                "--word <arg>  print only word statistics\n" +
                "--quit, end program\n\n";
    }
}
