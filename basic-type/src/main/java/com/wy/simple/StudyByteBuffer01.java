package com.wy.simple;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 对bytebuffer先写后读
 * @author Jane
 */
public class StudyByteBuffer01 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        write(byteBuffer);
        read(byteBuffer);
    }


    private static void write(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 126);
        char c = 'a';
        byteBuffer.putChar(c);
        int i = 2323123;
        byteBuffer.putInt(i);
        boolean b = true;
        byteBuffer.put(b ? (byte) 1 : (byte) 0);
        long l = 298789739;
        byteBuffer.putLong(l);
        float f = 12.345f;
        byteBuffer.putFloat(f);
        double d = 13.31241248782973;
        byteBuffer.putDouble(d);
        String str = "Hello你好！";
        byteBuffer.put(str.getBytes());
    }

    private static void read(ByteBuffer byteBuffer) throws UnsupportedEncodingException {

        byteBuffer.flip();

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

        Byte[] bytes = new Byte[1024];

        String str = new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit()-1, "utf-8");

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
