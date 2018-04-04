package guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Test {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BillingModule());
        TestService testService = injector.getInstance(TestService.class);
        testService.display();
    }
}
