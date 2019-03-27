package objectmapper;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class TestModel {
    String x;
    String y;

    public TestModel(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public static enum Foo {
        foo, bar
    }

    public abstract Foo getValidFoo();
}
