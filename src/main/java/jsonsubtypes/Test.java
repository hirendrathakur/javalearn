package jsonsubtypes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Test {
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        String payload = "{\n" +
                "  \"type\":\"Derived1\",\n" +
                "  \"id\": \"123\",\n" +
                "  \"name\": \"common\",\n" +
                "  \"derived1\": \"derived1\"\n" +
                "}";

        Derived1 baseClass = objectMapper.readValue(payload, Derived1.class);
    }
}
