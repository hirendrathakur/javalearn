package jsonsubtypes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import objectmapper.JSONObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        System.out.println(LocalDate.now());
//        PocValue2 pocValue = new PocValue2();
//        pocValue.setX(new PocContentValue("Hi"));
//        System.out.println(JSONObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(pocValue));
//        JSONObjectMapper.INSTANCE.getObjectMapper().readValue("{\"x\":{\"v\":\"Hi\"}}", PocValue.class);
//        Derived1 derived1 = new Derived1();
//        derived1.setClassType(Type.derived1);
//        derived1.setDerived1("derived1");
//        derived1.setName("common");
//        derived1.setValue(new PocValue<>(new PocContentValue("Hi")));
//        System.out.println(JSONObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(derived1));
//        String payload = "{\n" +
//                "  \"classType\": \"derived1\",\n" +
//                "  \"value\": {\n" +
//                "    \"x\": {\n" +
//                "      \"v\": \"Hi\"\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"name\": \"common\",\n" +
//                "  \"derived1\": \"derived1\"\n" +
//                "}";
//        BaseClass derived2 = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(payload, Derived1.class);
//        System.out.println("Done");
//        System.out.println(derived1.toString());
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
