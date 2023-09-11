package enums;

public enum SellersOptions {
    INCLUDE("1"),
    EXCLUDE("2");

    private String value;

    SellersOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
