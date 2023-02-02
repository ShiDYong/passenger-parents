package com.mason.nio;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yongshi
 * @date 2023/2/2 23:30
 * @Description 如果List中存储ByteBuffer数据类型，则可以使用List中的toArray()方法转成ByteBuffer[]数组类型
 */
public class BufferListToArray {
    public static void main(String[] args) {
         ByteBuffer byteBuffer1 = ByteBuffer.wrap(new byte[]{'a', 'b', 'c'});
         ByteBuffer byteBuffer2 = ByteBuffer.wrap(new byte[]{'x', 'y', 'z'});
         ByteBuffer byteBuffer3 = ByteBuffer.wrap(new byte[]{'1', '2', '3'});

        List<ByteBuffer> list = new ArrayList<>();
        list.add(byteBuffer1);
        list.add(byteBuffer2);
        list.add(byteBuffer3);
        ByteBuffer[] byteBuffersArray = new ByteBuffer[list.size()];
        list.toArray(byteBuffersArray);
        System.out.println(byteBuffersArray.length);

        for (int i = 0; i < byteBuffersArray.length; i++) {
          ByteBuffer eachByteBuffer =  byteBuffersArray[i];
          while (eachByteBuffer.hasRemaining()){
              System.out.print((char) eachByteBuffer.get());
          }
            System.out.println();
        }


    }

}
