package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Derived2 extends BaseClass {
    String id;
    String derived2;

    public Derived2(@JsonProperty("type") String type, @JsonProperty("id") String id, @JsonProperty("derived2") String derived2) {
        super(type);
        this.id = id;
        this.derived2 = derived2;
    }

//    public Derived2(String type) {
//        super(type);
//    }


//    public Derived2(String name, String id, String derived2) {
//        super("d");
//        this.id = id;
//        this.name = name;
//        this.derived2 = derived2;
//    }
}
