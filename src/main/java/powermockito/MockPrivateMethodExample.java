package powermockito;

import java.util.Date;

/**
 * Example class to test the mocking of private method.
 * @author Meraj
 */
public class MockPrivateMethodExample {

    public String getDetails() {
        return "";
    }

    private String iAmPrivate(int x) {
        System.out.println("iAmPrivate");
        return new Date().toString();
    }
}


