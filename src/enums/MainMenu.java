package enums;

public enum MainMenu {
    AUTO(1),
    MANUAL(2),
    EXIT(3)

    ;

    private final int value;

    MainMenu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
