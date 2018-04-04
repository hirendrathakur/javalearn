package mutability;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Mutate {
    public String mutable;
    Mutate(String x) {
        this.mutable = x;
    }
}
