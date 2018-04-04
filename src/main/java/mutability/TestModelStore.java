package mutability;

import java.util.HashMap;
import java.util.Map;

public class TestModelStore {
    private static Map<String, TestModel> store = new HashMap<>();
    public TestModel getTestModel(String x) {
        return store.get(x);
    }

    public void addToStore(String x, TestModel testModel) {
        store.put(x, testModel);
    }
}
