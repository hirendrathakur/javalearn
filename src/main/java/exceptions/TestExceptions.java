package exceptions;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import objectmapper.TestModel;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class TestExceptions {
    public static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
//        TestExceptions testExceptions = new TestExceptions();
//        testExceptions.test();

        List<String> list = Arrays.asList("a","b","c","d","e","f","g","h","i","k");
        Lists.partition(list, 3).forEach(System.out::println);

//        int pageSize = 3;
//
////        IntStream.range(0, (list.size() + pageSize-1) / pageSize)
////                .mapToObj(i -> list.subList(i * pageSize, Math.min(pageSize * (i + 1), list.size())))
////                .forEach(System.out::println);
//        int batches = (int)(Math.ceil((double) list.size()/(double) pageSize));
//        for(int i=0;i<batches;i++){
//            System.out.println(list.subList(i*pageSize,Math.min((i+1)*pageSize,list.size())));
//        }
    }

    private void test() {
        try
        {
            throw new IOException("");
        } catch (JsonParseException e) {
            System.out.println("caught JsonParseException");
        } catch (IOException io ) {
            System.out.println(getClass().getSimpleName());
            log.error("Error {}", getClass().getSimpleName());
        }
    }
}
