package com.mason.ATD.hash;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/25 16:02
 */
public class HashCodeDemo {
    public static void main(String[] args) {
        int g = 31;
        String s = "Java";
        System.out.println("Object类带散列码：" + s.hashCode());
        System.out.println("自写带散列函数计算带散列码： " + getHashCode(s, g));
        //“Java”.hashCode() 有相同的值
        //将散列码压缩为数组的下标
        int hashCode = getHashCode(s, g);
        int index = hashCode % 101;
        System.out.println("该字符串映射的数组下标：" + index);
        //当传入以下时会出现地址冲突
        String x = "x";
        int hashCode1 = getHashCode(x, g);
        int index1 = hashCode1 % 101;
        System.out.println("出现相同的数组下标地址：" + index1);
        System.out.println("映射到同一个数组的下标，出现冲突了吗？" +(index == index1 ? true:false));
    }


    /**
     * 生成字符串的更好散列码的方法：根据每个字符在字符串中的
     * 位置，让其Unicode值乘上一个因子。然后将这些乘积相加得到散列码。
     *
     * @param s 传入的字符串
     * @param g 常数
     * @return 返回散列码
     */
    public static int getHashCode(String s, int g) {
        int hash = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            hash = g * hash + s.charAt(i);
        }
        return hash;
    }

    /**
     * 将散列码压缩为列表的下标的方法
     * @param key
     * @return
     */
    //private int getHashIndex(K key) {
    //    int hashIndex = key.hashCode() % hashTable.length();
    //    if (hashIndex < 0)
    //      hashIndex = hashIndex + hashTable.length;
    //return hashIndex;

    //}
}
