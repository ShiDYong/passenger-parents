package com.junit.test;

import com.mason.junit.controller.CountedList;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author Mason
 * @Description CountedListTest的测试类
 * @date 2022/5/21 21:45
 */
public class CountedListTest {
    private CountedList list;

    @BeforeAll // 在任何其他测试方法操作之前运行一次的方法
    static void beforeAllMsg() {
        System.out.println(">>> Starting CountedListTest");
    }

    @AfterAll
    static void afterAllMsg() { //在任何其他测试方法操作之后只运行一次的方法
        System.out.println(">>>Finished CountedListTest");
    }

    @BeforeEach //通常用于创建和初始化公共对象的方法，并在每次测试前运行。可以将所有这样的初始化放在测试类的构造函数中
    // 但这样更加清晰
    public void initialize() {
        list = new CountedList();
        System.out.println("Set up for " + list.getId());
        for (int i = 0; i < 3; i++) {
            list.add(Integer.toString(i));
        }
    }

    @AfterEach  //如果必须每次测试后执行清理，那就用这个注解
    public void cleanup() {
        System.out.println("Clean up " + list.getId());
    }

    @Test
    public void inset() {
        System.out.println("Running testInsert()");
        assertEquals(list.size(), 3);
        list.add(1, "Insert");
        assertEquals(list.size(), 4);
        assertEquals(list.get(1), "Insert");
    }

    @Test
    public void replace() {
        System.out.println("Running testReplace");
        assertEquals(list.size(), 3);
        list.set(1, "replace");
        assertEquals(list.size(), 3);
        assertEquals(list.get(1), "replace");
    }

    // 只要没有注解Test，该方法就不会主动执行
    private void compare(List<String> lst, String[] strs) {
        assertArrayEquals(lst.toArray(new String[0]), strs);
    }

    @Test
    public void order() {
        System.out.println("Running testOrder()");
        compare(list, new String[]{"0", "1", "2"});
    }

    @Test
    public void remove() {
        System.out.println("Running testRemove()");
        assertEquals(list.size(), 3);
        list.remove(1);
        assertEquals(list.size(), 2);
        compare(list, new String[]{"0", "2"});

    }

    @Test
    public void addAll() {
        System.out.println("Running addAll()");
        list.addAll(Arrays.asList(new String[]{
                "An", "African", "Swallow"
        }));
        assertEquals(list.size(),6);
        compare(list,new String[]{"0","1","2","An", "African", "Swallow"});

    }


}
