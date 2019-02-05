package jsonsubtypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Type {
    private static final String derived1 = "Derived1";
    private static final String derived2 = "Derived2";
    private String value;

    public Type(String value) {
        this.value = value;
    }
}
