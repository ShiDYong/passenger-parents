package com.mason.nio;

import java.nio.ByteBuffer;

/**
 * @date 2023/2/4 23:34
 * @Description ByteBufferAPI的Put和Get使用
 */
public class ByteBufferAPIPutGet_1 {
    public static void main(String[] args) {
         ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("A capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        //abstract ByteBuffer put(byte b)方法的作用：使用相对位置的get()操作，读取此缓冲区"当前位置"的字节，然后改位置递增
        //单个字节put和get
        byteBuffer.put((byte) 125);
        System.out.println("A2 capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        byteBuffer.put((byte) 126);
        System.out.println("A3 capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        byteBuffer.put((byte) 127);
        System.out.println("A4 capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        byteBuffer.rewind();
        System.out.println("A5 capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        System.out.println(byteBuffer.get());
        System.out.println("A6 capacity = " + byteBuffer.capacity() + " limit =" + byteBuffer.limit() +"position" +
                "" + byteBuffer.position());
        System.out.println(byteBuffer.get());

        /**
         * 批量的put()和get()的实现
         *
         */

        byte[] byteArray1 = {1,2,3,4,5,6,7,8};
        byte[] byteArray2 = new byte[]{55,66,77,88};
        //开辟10个空间
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(10);
        //将byteArray1放进缓冲区的8个位置
        byteBuffer2.put(byteArray1);
        //执行put()方法后位置发生改变，将位置设置成2
        byteBuffer2.position(2);
        //将byteArray2的66，77，88放入缓冲区的第3位
        //这里的offset:要读取的第一个字节在"在数组中的偏移量"，并不是缓冲区的偏移量，必须为负且不大于src.length;
        //length:要从给定数组读取的字节的数量，必须为非负数且不大于src.length-offset.
        byteBuffer2.put(byteArray2,1,3);
        System.out.println("A = ");
         byte[] getByte = byteBuffer2.array();
        for (int i = 0; i < getByte.length; i++) {
            System.out.print(getByte[i] + " ");

        }
        System.out.println();

        byteBuffer2.position(1);
         byte[] byteArrayOut = new byte[byteBuffer2.capacity()];
         //使用get()方法从缓冲区position值为1的位置开始，向byteArrayOut数组的索引为3处
        //一共复制4个字节,说明get(byte[],dst,int offset,int length)获得数据的位置参考
        //的是Buffer当前的position位置
         byteBuffer2.get(byteArrayOut,3,4);
        System.out.println("B= ");
        //打印byteArrayOut数组中的内容
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i] + " ");

        }

        /**
         * put(byte[],dst,int offset,int length)需要注意两种异常的情况：
         * 1.offset+length的值大于src.length时，抛出IndexOutBoundsException异常；
         * 2.当参数length的值大于buffer.remaining时，抛出BufferOverException异常
         * 以上两种情况都不输出字节
         *
         */
//        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
//         ByteBuffer buffer = ByteBuffer.allocate(10);
//        //offset+length的值大于src.length时
//        buffer.put(byteArrayIn1,0,buffer.capacity());
//         buffer.position(9);
//         //当参数length的值大于buffer.remaining时
//         buffer.put(byteArrayIn1,0,4);
//
        System.out.println();
         //避免以上向缓冲区中写入数据时有写多或写少的情况，可以先判断缓冲的剩余和数组的剩余谁少
        byte[] byteArrayIn2 = {1,2,3,4,5,6,7,8,9,10,11,12};
        ByteBuffer buffer2 = ByteBuffer.allocate(10);
        int getArrayIndex = 0;
        while (getArrayIndex < buffer2.capacity()){
            int readLength = Math.min(buffer2.remaining(), byteArrayIn2.length - getArrayIndex);
            buffer2.put(byteArrayIn2,getArrayIndex,readLength);
            //为了下面将缓冲流中所有的数据导出来，先执行flip();
            buffer2.flip();
            //将缓冲流的数据导出来
            byte[] getArray = buffer2.array();
            for (int i = 0; i < buffer2.limit(); i++) {
                System.out.print(getArray[i] + " ");
            }
            getArrayIndex = getArrayIndex + readLength;
            //执行下一个循环前清除操作
            buffer2.clear();

        }

        /**
         * get(byte[],dst,int offset,int length)需要注意两种异常的情况：
         * 1.offset+length的值大于dst.length时，抛出IndexOutBoundsException异常；
         * 2.当参数length的值大于buffer.remaining时，抛出BufferOverException异常
         * 以上两种情况都不输出字节
         */
        byte[] byteArrayIn3 = {1,2,3,4,5,6,7};
        ByteBuffer buffer3 = ByteBuffer.wrap(byteArrayIn3);
        //offset+length的值大于dst.length时，抛出IndexOutBoundsException异常；
        byte[] byteArrayOut3 = new byte[5];
         buffer3.get(byteArrayOut3,0,7);
       // 当参数length的值大于buffer.remaining时，抛出BufferOverException异常
        buffer3.position(5);
        byte[] byteArrayOut4 = new byte[500];
        buffer3.get(byteArrayOut3,0,50);

        //针对以上从缓冲区获得数据时有可能取多或者取少的情况，可以使用以下代码进行解决；
        while (buffer3.hasRemaining()){
             int readLength = Math.min(buffer3.remaining(), byteArrayOut3.length);
             buffer3.get(byteArrayOut3,0,readLength);
            for (int i = 0; i < readLength; i++) {
                System.out.print(byteArrayOut3[i] + " ");

            }
            System.out.println();
        }



    }
}
