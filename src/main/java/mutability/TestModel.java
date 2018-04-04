package mutability;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestModel {
    private String x;
    private String y;
    private Mutate mutate;
    TestModel(String x, String y, Mutate mutate) {
        this.x = x;
        this.y = y;
        this.mutate = mutate;
    }
    public Mutate getMutate() {
        return new Mutate(mutate.getMutable());
    }
}
