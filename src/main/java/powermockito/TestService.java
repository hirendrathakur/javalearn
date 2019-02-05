package powermockito;

import enums.TestModel;

public class TestService {
    public void entryFunction(String arg1) {
        System.out.println(arg1);
        //call to static function
        int x = StaticResource.getValue();
        System.out.println(x);
        //calling function that will spy
        someFunctionToSpy();

        System.out.println("done");

    }

    public int someFunctionToSpy() {
        TestModel testModel = new TestModel();
        testModel.getName();
        return 1;
    }
}
