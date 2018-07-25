package parser;

public class CommandLineParser {

    public Options parse(final String inputStream) {
        Options options = new Options();
        if (inputStream.contains("--char")) {
            options.add("--char", inputStream.substring(6));
        } else if (inputStream.contains("--word")) {
            options.add("--word", inputStream.substring(6));
        } else if (inputStream.contains("--h")) {
            options.add("--h", null);
        }

        return options;
    }
}
