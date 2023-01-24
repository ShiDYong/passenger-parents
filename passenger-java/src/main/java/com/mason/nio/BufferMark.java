package com.mason.nio;

import java.nio.ByteBuffer;

/**
 * @author yongshi
 * @date 2023/1/23 21:41
 * @Description 在缓冲区的位置设置标记
 */
public class BufferMark {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        final ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("byteBuffer.capacity=" + byteBuffer.capacity());
        byteBuffer.position(1);
        //在位置1设置mark
        byteBuffer.mark();
        System.out.println("byteBuffer.position = "+ byteBuffer.position());

        //改变位置
        byteBuffer.position(2);
        System.out.println("byteBuffer.position位置改变" + byteBuffer.position());
        //位置重置
        byteBuffer.reset();
        System.out.println();
        System.out.println("byteBuffer.position "+ byteBuffer.position());




    }


}
