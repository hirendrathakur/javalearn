package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXTERNAL_PROPERTY,
        visible = true,
        property = "derived1Type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Derived1Type1.class, name = "derived1Type1")
})
public class Derived1 extends BaseClass {
    String derived1Type1;
    String name;
    String derived1;

    public Derived1(@JsonProperty("derived1Type1") String derived1Type1, @JsonProperty("name") String name, @JsonProperty("type") String type, @JsonProperty("derived1") String derived1) {
        super(type);
        this.name = name;
        this.derived1 = derived1;
    }

//    public Derived1(String type) {
//        super(type);
//    }

//    public Derived1(String name, String type, String id, String derived1) {
//        super(type);
//        this.id = id;
//        this.name = name;
//        this.derived1 = derived1;
//    }
}
