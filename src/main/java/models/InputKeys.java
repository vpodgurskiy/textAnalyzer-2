package models;

public enum InputKeys {

    /**
     * варианты входящих ключей - самый первый ключ в обрабатываемой строке
     *
     * full - дефолтное значение, подставляется если ключи не заданы - полный анализ
     * help - выводит помощь, с описанием ключей программы
     * quit - завершение работы преложения
     * chr - анализ общего количества символов, символов без пробела и повторяющегося числа букв
     * word - анализ количества повторяющихся слов
     */
    full(0), help(1), quit(2), chr(3), word(4);

    private int numVal;

    InputKeys(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }

}

