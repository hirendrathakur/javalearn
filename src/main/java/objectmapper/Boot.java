package objectmapper;

import javassist.ClassPool;

public class Boot {
    //    public static void main(String[] args) throws Exception {
//        ClassPool pool = ClassPool.getDefault();
//        for (long l = 0; l < Long.MAX_VALUE; l++) {
//            Thread.sleep(10);
//            pool.makeClass("com.example.Kitty" + l).toClass();
//        }
//    }
//
//    private static void block1(long x) throws Exception {
//        ClassPool pool = ClassPool.getDefault();
//        for (long l = 0; l < x; l++) {
//            pool.makeClass("com.example.Kitty" + l).toClass();
//        }
//    }
//
//    public static void block2(long x) throws Exception {
//        ClassPool pool = ClassPool.getDefault();
//        for (long l = 0; l < x; l++) {
//            pool.makeClass("com.example.Kitty2" + l).toClass();
//        }
//    }
    public static void main(String[] args) throws Exception {
        TestModelDerived testModel = new TestModelDerived("x","Y");
        System.out.println(JSONObjectMapper.INSTANCE.getObjectMapper().writeValueAsString(testModel));
        TestModelDerived testModel1 = JSONObjectMapper.INSTANCE.getObjectMapper().readValue("{\"x\":\"x\",\"y\":\"Y\",\"validFoo\":\"foo\"}", TestModelDerived.class);
        System.out.println(testModel.toString());
    }
}
