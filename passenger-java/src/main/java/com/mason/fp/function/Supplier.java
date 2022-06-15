package com.mason.fp.function;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.DoubleSupplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/6/15 22:16
 */
public class Supplier {
    public static void main(String[] args) {
         Logger logger = Logger.getLogger("...");
         DoubleSupplier doubleSupplier = new DoubleSupplier() {
             @Override
             public double getAsDouble() {
                 return  Math.random();
             }
         };
         doubleSupplier = () ->Math.random();
         doubleSupplier = Math::random;
         logger.info(String.valueOf(doubleSupplier));

        //在集合中查找名字
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee","Cnara", "Zoe", "Jayne","Simon",
                "River", "Shepherd Book");
        Optional<String> first = names.stream().filter(name ->name.startsWith("C")).findFirst();
        System.out.println(first.orElse("None"));

        System.out.println(first.orElse(String.format("No result found in %s", names.stream().collect(Collectors.joining(", ")))));
        System.out.println(first.orElseGet(() -> String.format("No result found in %s",
                names.stream().collect(Collectors.joining(", ")))));


    }
}
