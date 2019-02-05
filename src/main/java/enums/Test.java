package enums;

import objectmapper.JSONObjectMapper;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String payload = "{\"day\":\"MONDAY\",\"name\":\"hirendra\"}";
        TestModel testModel = JSONObjectMapper.INSTANCE.getObjectMapper().readValue(payload, TestModel.class);
        System.out.println(testModel.day);
        System.out.println(Day.valueOf("MONDAYj"));

//        String day = "monday";
//        Day day1 = Day.valueOf(day);
//        System.out.println(day1);
    }
}
