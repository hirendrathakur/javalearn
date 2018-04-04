package inheritence;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Test {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        String payload = "{\"x\":\"hirendra\"}";
        Parent parent = objectMapper.readValue(payload, Parent.class);
        System.out.println(parent.x);
    }
}
