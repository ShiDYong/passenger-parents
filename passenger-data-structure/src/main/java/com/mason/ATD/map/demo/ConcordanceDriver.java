package com.mason.ATD.map.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/4/25 14:20
 */
public class ConcordanceDriver {
    public static void main(String[] args) {
        Concordance concordance = new Concordance();
        String fileName = "/Users/yongshi/Downloads/MyCode/Java/passenger-parents/passenger-data-structure/src/main/java/com/mason/ATD/map/demo/Data3.txt";

        try {
            Scanner data = new Scanner(new File(fileName));
            concordance.readFile(data);
        } catch (FileNotFoundException e) {
            System.out.println("File not found"+ e.getMessage());
        }
        concordance.display();
    }
}
