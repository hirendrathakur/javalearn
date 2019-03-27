package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        visible = true,
        property = "classType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Derived1.class, name = "derived1"),
        @JsonSubTypes.Type(value = Derived2.class, name = "derived2")
})

@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class BaseClass<T> extends Value {

    T value;
//    public BaseClass(String type) {
//        this.type = type;
//    }
}
