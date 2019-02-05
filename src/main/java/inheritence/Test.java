package inheritence;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Test {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String payload = "{\n" +
                "  \"value\":{\"child1\":\"child1\"},\n" +
                "  \"parent\":\"parent\"\n" +
                "}";
        Parent parent = objectMapper.readValue(payload, objectMapper.getTypeFactory().constructType(Parent.class));
        System.out.println("done");
    }
}
