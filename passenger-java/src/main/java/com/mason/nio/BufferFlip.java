package com.mason.nio;

import java.nio.CharBuffer;
import java.nio.InvalidMarkException;

/**
 * @author yongshi
 * @date 2023/1/24 15:59
 * @Description 反转此缓冲区
 */
public class BufferFlip {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a', 'b', 'c', 'd'};
        final CharBuffer charBuffer = CharBuffer.wrap(charArray);
        charBuffer.position(3);
        charBuffer.mark();
        charBuffer.flip();
        System.out.println("charBuffer.position = " + charBuffer.position());

        System.out.println();

        System.out.println("charBuffer.limit = " + charBuffer.limit());
        System.out.println();

        try {
            charBuffer.reset();
        } catch (InvalidMarkException e) {
            System.out.println("charBuffer mark丢失");
        }


    }


}
