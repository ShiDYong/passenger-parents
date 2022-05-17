package com.mason.io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author Mason
 * @Description 该类主要用来提供读写具有固定尺寸的字符串
 * @date 2022/5/8 15:15
 */
public class DataIO {

    //该方法从输入流中读入字符，直到读入size个码元。
    public static String readFixedString(int size, DataInput in) throws IOException {
        StringBuilder b = new StringBuilder(size);
        int i = 0;
        boolean more = true;
        while (more && i < size) {
            char ch = in.readChar();
            i++;
            if (ch == 0) more = false;
            else b.append(ch);
        }
        in.skipBytes(2 * (size - 1));
        return b.toString();
    }


    //写出从字符串开头开始的指定位置数量的码元
    //如果码元过少，将用0值来补齐字符串
    public static void writeFixedString(String s, int size, DataOutput out) throws IOException {
        for (int i = 0; i < size; i++) {
            char ch = 0;
            if (i< s.length()) ch = s.charAt(i);
            out.writeChar(ch);


        }
    }

}
