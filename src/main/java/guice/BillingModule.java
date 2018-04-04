package guice;

import com.google.inject.AbstractModule;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Parent.class).to(Parent2Impl.class);
    }
}
