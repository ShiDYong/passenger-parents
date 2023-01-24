package com.mason.nio;

import java.nio.ByteBuffer;

/**
 * @author yongshi
 * @date 2023/1/23 21:59
 * @Description 缓冲区的核心技术点；capacity、limit、mark、position
 */
public class BufferAttribute {
    public static void main(String[] args) {
        //1.缓冲区的capacity、limit、position不能为负数
        //allocate()指定空间大小的缓冲区
        try {
            final ByteBuffer byteBuffer = ByteBuffer.allocate(-1);

        } catch (IllegalArgumentException e) {
            System.out.println("ByteBuffer的容量不能为负数");
        }


    }


}
