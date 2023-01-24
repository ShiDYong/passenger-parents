package com.mason.nio;

import java.nio.CharBuffer;

/**
 * @author yongshi
 * @date 2023/1/23 20:59
 * @Description Buffer类的limit
 */
public class BufferLimit {
    public static void main(String[] args) {
        char[] charArray= new char[]{'a', 'b', 'c', 'd','e'};
        final CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("charBuffer.capacity = " + charBuffer.capacity()+"" +
                "charBuffer.limit =" + charBuffer.limit());
        //设置此缓冲区的限制
        charBuffer.limit(3);
        System.out.println("=========================");
        System.out.println("charBuffer.capacity = " + charBuffer.capacity()+"" +
                "charBuffer.limit =" + charBuffer.limit());
        charBuffer.put(0, 'o');
        charBuffer.put(1,'p');
        charBuffer.put(2,'q');
        //这是第一个不可读不可写的索引
        //limit使用的场景就是反复地向缓冲区中存取数据时使用
        charBuffer.put(3,'r');
        charBuffer.put(4,'s');
        charBuffer.put(5,'t');
        charBuffer.put(6,'u');


    }
}
