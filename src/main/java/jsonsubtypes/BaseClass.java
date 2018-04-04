package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Derived1.class, name = "Derived1"),
        @JsonSubTypes.Type(value = Derived2.class, name = "Derived2")
})

@Getter
public class BaseClass {
    String name;
}
