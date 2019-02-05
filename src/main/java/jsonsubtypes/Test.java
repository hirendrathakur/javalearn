package jsonsubtypes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Test {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String payload = "{\n" +
                "  \"type\":\"Derived1\",\n" +
                "  \"id\": \"123\",\n" +
                "  \"name\": \"common\",\n" +
                "  \"derived1\": \"derived1\"\n" +
                "}";

        BaseClass derived1 = objectMapper.readValue(payload, BaseClass.class);
        System.out.println("Done");
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int noOfTries = Integer.parseInt(br.readLine());
//        while (noOfTries-- > 0) {
//            int inputSize = Integer.parseInt(br.readLine());
//            String[] inputArr = br.readLine().trim().split("\\s+");
//            int past = Integer.parseInt(inputArr[0]);
//            for (int j = 1; j < inputSize; j++) {
//                int current = Integer.parseInt(inputArr[j]);
//                if (current < past) {
//                    System.out.print(current + " ");
//                } else {
//                    System.out.print(-1 + " ");
//                }
//                past = current;
//            }
//            System.out.print(-1 + " ");
//        }
    }
}
