package com.mason.nio;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/**
 * @author yongshi
 * @date 2023/2/3 22:58
 * @Description 字节缓冲区分为直接字节缓冲区与非字节缓冲区, 这里简单介绍下其区别
 * 此方法主要为缓冲区的内容分配空间或者通过wrapping方法将现有的byte[]数组包装到缓冲区中来创建
 */
public class AllocateDirectAndAllocate {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //分配新的直接缓冲区，位置为零，其界限为其容量，标记不清楚
        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(100);
        //分配一个新的非直接字节缓冲区，有一个底层实现数组，且数组偏移量将为零
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(200);

        System.out.println("byteBuffer1 position = " + byteBuffer1.position() + "limit = " + byteBuffer1.limit());
        System.out.println("byteBuffer2 position = " + byteBuffer2.position() + "limit = " + byteBuffer2.limit());
        System.out.println("byteBuffer1= " + byteBuffer1 + "isDirect= " + byteBuffer1.isDirect());
        System.out.println("byteBuffer2= " + byteBuffer2 + "isDirect= " + byteBuffer2.isDirect());


        //使用allocateDirect()方法创建的缓冲区释放内存的方法：
        //1。手动释放内存的方法
        System.out.println("A");
        ByteBuffer buffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE);
        System.out.println("B");
        byte[] byteArray = new byte[]{1};
        System.out.println(Integer.MAX_VALUE);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            buffer.put(byteArray);

        }
        System.out.println("put end"); //执行到这里在某个时间出发GC垃圾会搜起进行内存的回收操作
        //往下这些步骤是手动释放内存个的方式
        //Thread.sleep(1000);
//        Method cleanerMethod = buffer.getClass().getMethod("cleaner");
//        cleanerMethod.setAccessible(true);
//        final Object returnValue = cleanerMethod.invoke(buffer);
//        Method clearnMethod = returnValue.getClass().getMethod("clean");
//        clearnMethod.setAccessible(true);
//        clearnMethod.invoke(returnValue);


        /**
         * 直接使用缓冲区是使用DirectByteBuffer类进行实现的，非直接缓冲区是使用HeapByteBuffer类进行实现的
         * 直接缓冲区的在内部使用sun.misc.Unsafe类进行值的处理，Unsafe类的作用是JVM与操作进行直接通信，提高程序
         * 运行的效率，但是在使用是不安全的，使用不当极有可能出现数据的上的错误
         * 非直接缓冲区在内部直接对byte[] hb字节数组进行操作，而且还是在JVM的堆中进行数据处理，因此效率相对慢一些

         */
        System.out.println("非直接缓冲区的性能=======");

        long beginTime2 = System.currentTimeMillis();
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(1900000000);
        for (int i = 0; i < 1900000000; i++) {
            byteBuffer3.put((byte) 123);

        }
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - beginTime2);
        //3.两种方式的性能对比：
        long beginTime = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1900000000);
        for (int i = 0; i < 1900000000; i++) {
            byteBuffer.put((byte) 123);

        }
        long endTime = System.currentTimeMillis();
        System.out.println("直接缓冲区性能");
        System.out.println(endTime - beginTime);


    }



}
