package analyzeModel;

public class CharStatistics implements ITextStatistics {

    private int totalChar;
    private int totalCharWithoutSpaces;

    /**
     * Метод возвращает значение поля totalChar
     * @return totalChar
     */
    public int getTotalChar() {
        return totalChar;
    }

    /**
     * Метод возвращает значение поля totalCharWithoutSpaces
     * @return totalCharWithoutSpaces
     */
    public int getTotalCharWithoutSpaces() {
        return totalCharWithoutSpaces;
    }


    /**
     * Конструктор структуры анализа.
     * @param totalChar всего символов в тексте
     * @param totalCharWithoutSpaces всего символов без пробелов
     */
    public CharStatistics(final int totalChar, final int totalCharWithoutSpaces) {
        this.totalChar = totalChar;
        this.totalCharWithoutSpaces = totalCharWithoutSpaces;
    }

    /**
     * Переопределенный метод, формирует строку вывода в консоль
     * @return str
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n")
                .append(String.format("Всего символов в тексте: %s\n", this.getTotalChar()))
                .append(String.format("Всего символов без пробелов: %s\n", this.getTotalCharWithoutSpaces()))
                .append("\n");

        return stringBuilder.toString();
    }
}
