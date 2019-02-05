package inheritence;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Parent {
    Object value;
    String parent;

    public Parent(@JsonProperty("value") Object value, @JsonProperty("parent") String parent) {
        this.value = value;
        this.parent = parent;
    }
}
