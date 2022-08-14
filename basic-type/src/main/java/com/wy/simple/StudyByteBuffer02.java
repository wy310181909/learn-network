package com.wy.simple;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * 转换带有数据的byte[] 为bytebuffer并读
 * @author Jane
 */
public class StudyByteBuffer02 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteBuffer init = init();
        read(init);
    }

    private static ByteBuffer init() {
        byte[] buffer = {126, 0, 97, 0, 35, 114, -77, 1, 0, 0, 0, 0, 17, -49, 43, 107, 65, 69, -123, 31, 64, 42, -97, -12, -121, -108, 46, 111, 72, 101, 108, 108, 111, -28, -67, -96, -27, -91, -67, -17, -68, -127,0};
        ByteBuffer byteBuffer = ByteBuffer.wrap(buffer, 0, buffer.length);
        return byteBuffer;
    }

    private static void read(ByteBuffer byteBuffer) throws UnsupportedEncodingException {

        byte be = byteBuffer.get();

        // char
        char c = byteBuffer.getChar();

        // int
        int i = byteBuffer.getInt();

        // bool
        boolean b = byteBuffer.get() == 1;

        // Long
        long l = byteBuffer.getLong();

        // float
        float f = byteBuffer.getFloat();

        // double
        double d = byteBuffer.getDouble();

        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        byte[] array = byteBuffer.array();
        byte[] bytes = new byte[1024];
        for (int j = position; j < limit; j++) {
            bytes[j] = array[j];

        }
        String str = new String(bytes, position, limit-1, "utf-8");

        System.out.println(
                 be + "\n"
                + c + "\n"
                + i + "\n"
                + b + "\n"
                + l + "\n"
                + f + "\n"
                + d + "\n"
                + str + "\n");
    }
}
