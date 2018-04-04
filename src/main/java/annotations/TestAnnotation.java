package annotations;

public class TestAnnotation {
    public static void main(String[] args) {
        testAnnotation(AnnotatedClass.class);
    }

    private static void testAnnotation(Class<?> classType) {
        System.out.println(classType.getAnnotation(WorkerModule.class).appName());
    }
}
