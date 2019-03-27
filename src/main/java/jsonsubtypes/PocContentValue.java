package jsonsubtypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PocContentValue extends Value {
    String v;

    public PocContentValue(String value) {
        this.v = value;
    }
}
