package jsonsubtypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@ToString
public class Derived1 extends BaseClass<PocValue> {
    Type classType;
    String name;
    String derived1;

    public Derived1() {}

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
