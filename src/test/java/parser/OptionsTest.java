package parser;

import models.InputKeys;
import models.Options;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class OptionsTest {

    private final InputKeys inputKey = InputKeys.chr;
    private final String inputArgument = "test";
    private Options options;

    @Before
    public void initialize() {
        options = new Options();
        options.setInputKey(inputKey);
        options.setInputArgument(inputArgument);
    }

    /**
     * Тест проверяет корректность установки входящего ключа
     */
    @Test
    public void get_setInputKey() {
        assertThat(inputKey).isEqualTo(options.getInputKey());
    }

    /**
     * Тест проверяет корректность установки входящего аргумента
     */
    @Test
    public void get_setInputArgument() {
        assertThat(inputArgument).isEqualTo(options.getInputArgument());
    }
}