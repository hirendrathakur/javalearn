package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        visible = true,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Derived1.class, name = "Derived1"),
        @JsonSubTypes.Type(value = Derived2.class, name = "Derived2")
})

@Data
public class BaseClass {
    String type;

    public BaseClass(@JsonProperty("type") String type) {
        this.type = type;
    }

//    public BaseClass(String type) {
//        this.type = type;
//    }
}
