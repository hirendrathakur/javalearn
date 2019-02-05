package reflections;

import annotations.WorkerModule;
import org.reflections.Reflections;

import java.util.Set;

public class TestReflections {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("annotations");
        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(WorkerModule.class);
        for(Class<?> clz: classSet) {
            System.out.println(clz.getSimpleName());
        }
    }
}
