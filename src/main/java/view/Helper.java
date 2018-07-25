package view;

public class Helper {

    public static void printHelp() {

        StringBuilder stringBuilder = new StringBuilder()
                .append("\n")
                .append("usage:\n\n")
                .append("--h, print help\n")
                .append("--char <arg>  print only char statistics\n")
                .append("--word <arg>  print only word statistics\n")
                .append("<arg> print full statistics\n");

        System.out.printf(stringBuilder.toString());
    }
}
