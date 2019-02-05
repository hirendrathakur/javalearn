package powermockito;

import javax.annotation.Nullable;
import java.util.Optional;

public class StaticResource {
    public boolean upgradeAllCustomers() {
        getValue();
        return true;
    }
    public static int getValue() {
        return 1;
    }

    public static void main(String[] args) {
        String x = "test";

        System.out.println(Optional.ofNullable(getString()).orElse("fallback"));
    }

    @Nullable
    static String getString() {
        return null;
    }
}
