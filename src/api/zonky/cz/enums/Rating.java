package api.zonky.cz.enums;

/**
 * Enum representation of rating values.
 *
 * @author labut
 */
public enum Rating {
    AAAAA("A**", "AAAAA"),
    AAAA("A*", "AAAA"),
    AAA("A++", "AAA"),
    AA("A+", "AA"),
    A("A", "A"),
    B("B", "B"),
    C("C", "C"),
    D("D", "D");

    private String name;
    private String value;

    private Rating(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
