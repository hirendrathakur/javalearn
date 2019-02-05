package map;

import java.util.HashMap;
import java.util.Map;

public class Boot {
    public static void main(String[] args) {
        Map<Student, Integer> studentIntegerMap = new HashMap<>();
        studentIntegerMap.put(new Student("hirendra1", 1), 1);
        studentIntegerMap.put(new Student("hirendra2", 2), 2);
        for(Map.Entry<Student, Integer> entry : studentIntegerMap.entrySet()) {
            System.out.println(entry.hashCode());
        }

        System.out.println(studentIntegerMap.get(new Student("hirendra1",1)));
    }
}
