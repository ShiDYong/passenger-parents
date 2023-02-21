package com.mason.nio;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @author yongshi
 * @date 2023/2/5 12:14
 * @Description put()和get()方法的使用二
 */
public class ByteBufferAPIPutGet_2 {
    public static void main(String[] args) {
        //put(ByteBuffer src):相对于批量put方法，这种方法将给定源缓冲区中的剩余字节传输到此缓冲区的当前位置中
        byte[] arrayByte = new byte[]{3, 4, 5, 6, 7, 8};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        System.out.println("A=" + byteBuffer.position());
        byteBuffer.put(arrayByte);//相对位置的操作
        System.out.println("B=" + byteBuffer.position());
        byteBuffer.flip();
        byteBuffer.position(3);
        System.out.println("C=" + byteBuffer.position());
        //获取缓冲流中的数据
        byte[] newArray = new byte[byteBuffer.remaining()];
        byteBuffer.get(newArray);//相对位置进行读取操作
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");

        }

        //get(BufferBuffer src)
        //在使用public final ByteBuffer put(byte[] src)方法的过程中，出现字节数组的length大于或等于或者小于或等于
        //缓冲区的remaining的剩余空间时，需要进行的特殊出来，即分批进行处理
        byte[] byteArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
        int byteArrayCurrentIndex = 0;
        int byteArrayRemaining = 0;
        while (byteArrayCurrentIndex < byteArray.length) {
            byteArrayRemaining = byteArray.length - byteArrayCurrentIndex;
            int readLength = Math.min(byteArrayRemaining, byteBuffer1.remaining());
            byte[] newByteArray = Arrays.copyOfRange(byteArray, byteArrayCurrentIndex, byteArrayCurrentIndex + readLength);
            byteBuffer1.put(newByteArray);
            byteBuffer1.flip();
            //将缓冲流中的数据转为数组
            final byte[] getByte = byteBuffer1.array();
            for (int i = 0; i < byteBuffer1.limit(); i++) {
                System.out.print(getByte[i] + "");
            }
            System.out.println();
            byteArrayCurrentIndex = byteArrayCurrentIndex + readLength;
            byteBuffer1.clear();


        }

        //如果在使用get(byte[] dst)方法的过程中，出现字节数组的length大于或等于或者小于或者等于缓冲区的remaining时，
        //那么也要进行处理
        byte[] byteArray3 = new byte[]{1,2,3,4,5,6,7,8,};
         ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArray3);
         int copyDataCount = 3;
         while (byteBuffer2.hasRemaining()){
             byte[] copyByteArray = new byte[Math.min(byteBuffer2.remaining(), copyDataCount)];
             byteBuffer2.get(copyByteArray);
             for (int i = 0; i < copyByteArray.length; i++) {
                 System.out.print(copyByteArray[i]);
             }
             System.out.println();

         }


    }

}
