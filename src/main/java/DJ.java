import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DJ {
    @Getter
    @AllArgsConstructor
    public static class X {
        String x;
        Y y;
    }

    @Getter
    @AllArgsConstructor
    public static class Y {
        String x;
        List<String> y;
    }

    public static void main(String args[]) {
        System.out.println(new DJ().getY(new X("x", new Y("x", Collections.emptyList()))));
    }

    private String getY(X x) {
        return Optional.ofNullable(x.getY()).map(y->y.getY().isEmpty() ? null: y.getY().get(0)).orElse(null);
    }
}
