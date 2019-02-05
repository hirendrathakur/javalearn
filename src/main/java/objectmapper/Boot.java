package objectmapper;

import javassist.ClassPool;

public class Boot {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        for (long l = 0; l < Long.MAX_VALUE; l++) {
            Thread.sleep(10);
            pool.makeClass("com.example.Kitty" + l).toClass();
        }
    }

    private static void block1(long x) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        for (long l = 0; l < x; l++) {
            pool.makeClass("com.example.Kitty" + l).toClass();
        }
    }

    public static void block2(long x) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        for (long l = 0; l < x; l++) {
            pool.makeClass("com.example.Kitty2" + l).toClass();
        }
    }
}
