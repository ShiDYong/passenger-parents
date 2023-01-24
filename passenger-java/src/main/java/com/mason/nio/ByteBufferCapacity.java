package com.mason.nio;

import java.nio.*;

/**
 * @author yongshi
 * @date 2023/1/23 20:07
 * @Description NIO的使用之Buffer类常用的方法
 * capacity是指缓冲区的容量
 */
public class ByteBufferCapacity {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1, 2, 3};
        short[] shortArray = new short[]{1, 2, 3, 4};
        int[] intArray = new int[]{1,2,3,4,5};
        long[] longArray = new long[]{1,2,3,4,5,6};
        double[] doubleArray = new double[]{1,2,3,4,5,6,7};
        float[] floatArray = new float[]{1,2,3,4,5,6,7,8};
        char[] charArray = new char[]{'a','b','c','d','c'};

        //把byte装进缓冲流:wrap()是创建缓冲区的工厂方法
        final ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        final ShortBuffer shortBuffer = ShortBuffer.wrap(shortArray);
        final IntBuffer intBuffer = IntBuffer.wrap(intArray);
        final LongBuffer longBuffer = LongBuffer.wrap(longArray);
        final DoubleBuffer doubleBuffer = DoubleBuffer.wrap(doubleArray);
        final FloatBuffer floatBuffer = FloatBuffer.wrap(floatArray);
        final CharBuffer charBuffer = CharBuffer.wrap(charArray);
        //获取缓冲流中对应的名字
        System.out.println("byteBuffer = " + byteBuffer.getClass().getName());
        System.out.println("shortBuffer = " + shortBuffer.getClass().getName());
        System.out.println("intBuffer = " + intBuffer.getClass().getName());
        System.out.println("longBuffer = " + longBuffer.getClass().getName());
        System.out.println("doubleBuffer = " + doubleBuffer.getClass().getName());
        System.out.println("floatBuffer = " + floatBuffer.getClass().getName());
        System.out.println("charBuffer = " + charBuffer.getClass().getName());

        //获取对应缓冲区中的容量
        System.out.println("byteBuffer.capacity = " + byteBuffer.capacity());
        System.out.println("shortBuffer.capacity = " + shortBuffer.capacity());
        System.out.println("intBuffer.capacity = " + intBuffer.capacity());
        System.out.println("longBuffer.capacity = " + longBuffer.capacity());
        System.out.println("doubleBuffer.capacity = " + doubleBuffer.capacity());
        System.out.println("floatBuffer.capacity = " + floatBuffer.capacity());
        System.out.println("charBuffer.capacity = " + charBuffer.capacity());



    }
}
