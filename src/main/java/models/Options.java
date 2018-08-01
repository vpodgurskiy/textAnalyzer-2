package models;

public class Options {

    /**
     * Варианты ключей входящего потока
     * inputKey -  ключ, указывающий как парсить
     * inputArgument - ключ, указывающий что парсить
     * далее можно добавить еще ключи:
     * outputKey - ключ, указывающий что сделать с результатом анализа
     * OutputArgument - ключ, указывающий например в какой файл записать (имя файла)
     */
    private InputKeys inputKey;
    private String inputArgument;
    /***
     * Кстати, вот сюда-же стоит добавлять опции записи и чтения из файла. но это потом.
     * Мы еще будем обсуждать будет-ли оно создавать файл или писать в существующий.
     */

    /**
     * устанавливает inputKey.
     * @param inputKey
     */
    public void setInputKey(final InputKeys inputKey) {
        this.inputKey = inputKey;
    }

    /**
     * получает inputKey.
     * @return inputKey.
     */
    public InputKeys getInputKey() {
        return this.inputKey;
    }

    /**
     * устанавливает inputArgument.
     * @param inputArgument - ключ, указывающий что парсить
     */
    public void setInputArgument(final String inputArgument) {
        this.inputArgument = inputArgument;
    }

    /**
     * получает inputArgument - ключ, указывающий что парсить
     * @return inputArgument.
     */
    public String getInputArgument() {
        return this.inputArgument;
    }
}
