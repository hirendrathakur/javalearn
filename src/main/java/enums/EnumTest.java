package enums;

public enum EnumTest {

    Mon("Monday"),
    Tues("Tuesday"),
    Wed("Wednesday");

    private final String actualName;
    EnumTest (String s) {
        this.actualName = s;
    }

    public String getActualName() { return this.actualName; }
}
