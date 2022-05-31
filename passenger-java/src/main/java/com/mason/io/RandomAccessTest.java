package com.mason.io;

import java.io.*;
import java.time.LocalDate;

/**
 * @author Mason
 * @Description 随机读取文件操作
 * @date 2022/5/8 15:01
 */
public class RandomAccessTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 10, 1);
        staff[1] = new Employee("Harry Hacker", 35500, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 38000, 1990, 3, 15);

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("passenger-java/src/main/java/com/mason/io/employee.txt"))) {
            //Save all employee records to the file employee.txt
            for (Employee e : staff)
                writeData(out, e);

        }

        try (RandomAccessFile in = new RandomAccessFile("passenger-java/src/main/java/com/mason/io/employee.txt", "r")) {
            //计算数组的大小
            int n = (int) (in.length() / Employee.RECORD_SIZE);
            Employee[] newStaff = new Employee[n];

            //逆序读取Employee数据
            for (int i = n - 1; i >= 0; i--) {
                newStaff[i] = new Employee();
                in.seek(i * Employee.RECORD_SIZE);
                newStaff[i] = readData(in);
            }
            for (Employee e : newStaff)
                System.out.println(e);


        }


    }


    //为了写出一条固定的尺寸的记录，我们直接用二进制方式写出所有的字段
    private static void writeData(DataOutputStream out, Employee e) throws IOException {
        DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
        out.writeDouble(e.getSalary());
        LocalDate hireDay = e.getHireDay();
        out.writeInt(hireDay.getYear());
        out.writeInt(hireDay.getMonthValue());
        out.writeInt(hireDay.getDayOfMonth());
    }

    //读回数据
    private static Employee readData(DataInput in) throws IOException {
        String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
        double salary = in.readDouble();
        int y = in.readInt();
        int m = in.readInt();
        int d = in.readInt();
        return new Employee(name, salary, y, m - 1, d);

    }

}
