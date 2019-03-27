package jsonsubtypes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PocValue<T extends Value> {
    T x;

    public PocValue(T x) {
        this.x = x;
    }
}
