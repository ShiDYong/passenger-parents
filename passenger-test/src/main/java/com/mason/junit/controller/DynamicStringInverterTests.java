//package com.mason.junit.controller;
//
//import org.junit.jupiter.api.DynamicTest;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.function.Function;
//import java.util.stream.Stream;
//
///**
// * @author Mason
// * @Description Junit5的动态测试
// * @date 2022/5/26 22:31
// */
//public class DynamicStringInverterTests {
//
//    Stream<DynamicTest> testVersions(String id, Function<StringInverter, String> test) {
//        List<StringInverter> versions = Arrays.asList(
//                new Inverter1(), new Inverter2(),
//                new Inverter3(), new Inverter4()
//        );
//        return DynamicTest.stream(
//                versions.iterator(),
//                inverter -> inverter.getClass().getSimpleName(),
//                inverter -> {
//                    System.out.println(
//                            inverter.getClass().getSimpleName() +
//                                    ": " + id);
//                    try {
//                        if (test.apply(inverter) != "fail")
//                            System.out.println("Success");
//                    } catch (Exception | Error e) {
//                        System.out.println(
//                                "Exception: " + e.getMessage());
//                    }
//                }
//        );
//
//    }
//
//
//}
