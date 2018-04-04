package objectmapper;

import java.io.IOException;

public class Boot {
    public static void main(String[] args) throws IOException {
        String payload = "{\"x\":\"hirendra\",\"y\":\"thakur\"}";
        TestModel testModel = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(payload, TestModel.class);
        System.out.println(testModel.getX());
        System.out.println(testModel.copy(testModel).getX());
    }
}
