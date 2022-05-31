package com.mason.ATD.map.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Mason
 * @Description 查找单词出现的数量
 * @date 2022/4/25 10:42
 */
public class FrequencyCounterDriver {
    public static void main(String[] args) {
        FrequencyCounter wordCounter = new FrequencyCounter();
        String fileName = "/Users/yongshi/Downloads/MyCode/Java/passenger-parents/passenger-data-structure/src/main/java/com/mason/ATD/map/demo/Data2.txt";

        try {
            Scanner data = new Scanner(new File(fileName));
            wordCounter.readFile(data);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: "+ e.getMessage());
        }
        wordCounter.display();
    }
}
