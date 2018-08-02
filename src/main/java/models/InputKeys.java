package models;

public enum InputKeys {

    /**
     * варианты входящих ключей - самый первый ключ в обрабатываемой строке
     *
     * Может упростить написание ключей?
     * Кстати тут документацией стоит описать каждый ключ.
     * Откуда я знаю где там тот хелп... а мне тут, как программисту, нужно разобраться в коде.
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

