package com.mason.nio;

import java.nio.ByteBuffer;

/**
 * @author yongshi
 * @date 2023/2/2 23:13
 * @Description rewind()的用法和clear()、flip()的区别
 */
public class BufferRewindMethod {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("A capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        byteBuffer.position(1);
        byteBuffer.limit(3);
        byteBuffer.mark();
        System.out.println("B capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());

        //标记清除，位置position值为0，limit不变,在重新读取、重新写入时可以使用
        byteBuffer.rewind();
        System.out.println("C capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
       //将position = mark,将标记mark的值改为position的值
        byteBuffer.reset();
        System.out.println("D capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
       //将位置显示为0，还原一切状态
        byteBuffer.clear();
        System.out.println("E capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
    }


}
