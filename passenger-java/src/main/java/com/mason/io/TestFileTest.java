package com.mason.io;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Mason
 * @Description TODO
 * @date 2022/5/7 16:57
 */
public class TestFileTest {
    public static void main(String[] args) throws IOException {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 10, 1);
        staff[1] = new Employee("Harry Hacker", 35500, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 38000, 1990, 3, 15);
        //将这些记录保存到employee.txt中
        try (PrintWriter out = new PrintWriter("passenger-java/src/main/java/com/mason/io/employee.txt", "UTF-8")) {
            writeData(staff,out);
        }
        //Retrieve all records into a new array
        try(Scanner in = new Scanner(new FileInputStream("passenger-java/src/main/java/com/mason/io/employee.txt"),"UTF-8")){
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);

            }
        }



    }


    /**
     * Writes all employees in an array to a print writer
     *
     * @param employees an array of employee
     * @param out       a print writer
     */
    private static void writeData(Employee[] employees, PrintWriter out) {
        //writer number of employees
        out.println(employees.length);
        for (Employee e : employees) {
            writeEmployee(out,e);

        }

    }


    /**
     *
     * Writes employee data a print writer
     * @param out
     * @param e
     */
    private static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    /**
     * Reads an array of employees from a scanner
     * @param in the Scanner
     * @return the array of employees
     */
    public static Employee[] readData(Scanner in){
        //retrieve the array size
        int n = in.nextInt();
        in.nextLine();  // consume newline
        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i]= readEmployee(in);

        }
        return employees;
    }

    /**
     * Reads employee data from a buffered reader.
     * @param in
     * @return
     */
    public static Employee readEmployee(Scanner in){
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double salary = Double.parseDouble(tokens[1]);
        LocalDate hireDate = LocalDate.parse(tokens[2]);
        int year = hireDate.getYear();
        int month = hireDate.getMonthValue();
        int day = hireDate.getDayOfMonth();
        return new Employee(name,salary,year,month,day);
    }
}
