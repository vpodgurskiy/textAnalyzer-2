package parser;

import models.InputKeys;
import models.Options;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandLineParserTest {

    @Test
    public void parse() {
        final String inputStream = "--char test input key";
        final CommandLineParser parser = new CommandLineParser();
        final Options options = parser.parse(inputStream);
        assertThat(InputKeys.chr).isEqualTo(options.getInputKey());
        assertThat("test input key").isEqualTo(options.getInputArgument());
    }
}