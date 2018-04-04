package guice;

import com.google.inject.Inject;

public class TestService {
    @Inject
    Parent parent;

    public void display() {
        parent.display();
    }
 }
