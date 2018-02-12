package api.zonky.cz.enums;

/**
 * Enum representation of filter operations.
 *
 * @author labut
 */
public enum Operation {
    IN("in"),
    EQUAL("eq"),
    NOT_EQUAL("noteq"),
    GREATER("gt"),
    GREATER_EQUAL("gte"),
    LOWER("lt"),
    LOWER_EQUAL("lte");

    private String value;

    private Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
