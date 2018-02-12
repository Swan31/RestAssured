package api.zonky.cz.enums;

/**
 * Enum representation of field values that can be use to filter operations.
 *
 * @author labut
 */
public enum Field {
    RATING("rating"),
    TERMS_IN_MONTH("termInMonths");

    private String value;

    private Field(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
