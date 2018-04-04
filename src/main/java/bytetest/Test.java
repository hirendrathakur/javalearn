package bytetest;

import sun.jvm.hotspot.runtime.Bytes;

import java.nio.charset.Charset;

public class Test {

    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    public static void main(String[] args) {

        byte[] x = hexStringToByteArray("Hirendra");
        String s = new String(x, 0, x.length, UTF8_CHARSET);
        System.out.println(s);
    }
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
