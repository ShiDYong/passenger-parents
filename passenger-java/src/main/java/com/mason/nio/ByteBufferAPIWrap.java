package com.mason.nio;

import java.nio.ByteBuffer;

/**
 * @author yongshi
 * @date 2023/2/4 17:39
 * @Description ByteBuffer常用的API之wrap()：将byte数组包装到缓冲区中
 *              新的缓冲区将由给定的数组支持，缓冲区修改将导致数组修改,新缓冲区的
 *              的capacity和limit将为array.length，其位置position将为0，标记
 *              mark是不确定的
 */
public class ByteBufferAPIWrap {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray);
        //wrap(byte[] array,int offset, int length)方法并不具有suBString()方法截取的作用，
        //它的参数offset只是设置缓冲区的position值，而length确定limit值
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray, 2, 4);
        System.out.println(byteBuffer1+"byteBuffer1 capacity=" + byteBuffer1.capacity() +
                "limit =" +byteBuffer1.limit()+ "position= " + byteBuffer1.position());
        for (int i = 0; i < byteBuffer1.limit(); i++) {
            System.out.print(byteBuffer1.get(i));

        }

        System.out.println();
        System.out.println(byteBuffer2+"byteBuffer2 capacity=" + byteBuffer2.capacity() +
                "limit =" +byteBuffer2.limit()+ "position= " + byteBuffer2.position());
        for (int i = 0; i < byteBuffer2.limit(); i++) {
            System.out.print(byteBuffer2.get(i));

        }

    }
}
