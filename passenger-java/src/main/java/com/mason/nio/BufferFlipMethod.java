package com.mason.nio;

import java.nio.CharBuffer;

/**
 * @author yongshi
 * @date 2023/2/2 22:27
 * @Description final Buffer flip()方法的使用：常用在向缓冲区写入一些数据后，下一步读取缓冲区的数据之前调用
 *              以改变limit与position的值
 */
public class BufferFlipMethod {
    public static void main(String[] args) {
         CharBuffer charBuffer = CharBuffer.allocate(20);
        System.out.println("A position = " + charBuffer.position() + " limit =" + charBuffer.limit());
        //开始写数据到缓冲流中
        charBuffer.put("我是中国人我在中华人民共和国");
        System.out.println("B position = " + charBuffer.position() + " limit =" + charBuffer.limit());
        //将position的位置还原成0
        charBuffer.position(0);
        System.out.println("C position = " + charBuffer.position() + " limit =" + charBuffer.limit());

        for (int i = 0; i < charBuffer.limit(); i++) {
            //打印效果是"国"字后面有6个空格，这6个空格是无效的数据
            //只打印前14个字符，后6个字符不再读取
            System.out.print(charBuffer.get());

        }
        //以上代码是错误读取数据的代码，因为有6个空格是无效的数据的数据,读取最新的数据
        //下面是正确读取数据的代码
        System.out.println("D position = " + charBuffer.position() + " limit =" + charBuffer.limit());

        //还原缓冲区的状态
        charBuffer.clear();
        System.out.println("E position = " + charBuffer.position() + " limit =" + charBuffer.limit());
        //继续写入
        charBuffer.put("我是湖南人");
        System.out.println("F position = " + charBuffer.position() + " limit =" + charBuffer.limit());
        //设置for循环结束的位置，也就是新的limit值
       // charBuffer.limit(charBuffer.position());
      // charBuffer.position(0);
     //   System.out.println("G position = " + charBuffer.position() + " limit =" + charBuffer.limit());

//        for (int i = 0; i < charBuffer.limit(); i++) {
//            System.out.print(charBuffer.get());
//
//        }

        //使用flip()方法进行优化
        //final Buffer flip()方法的使用：常用在向缓冲区写入一些数据后，下一步读取缓冲区的数据之前调用
        //以改变limit与position的值
        charBuffer.flip();
        System.out.println("G position = " + charBuffer.position() + " limit =" + charBuffer.limit());
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get());

        }











    }
}
