package b5_collection.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Birthdate {
    private int year;
    private int month;
    private int day;

    public Birthdate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthdate birthdate = (Birthdate) o;
        return year == birthdate.year && month == birthdate.month && day == birthdate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }
}

class Employee2 {
    private String name;
    private double salary;
    private Birthdate birthdate;

    public Employee2(String name, double salary, Birthdate birthdate) {
        this.name = name;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Birthdate getBirthdate() {
        return birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee = (Employee2) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthdate, employee.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthdate=" + birthdate +
                '}';
    }
}

public class HashSetExample02 {
    public static void main(String[] args) {
        Set<Employee2> employees = new HashSet<>();
        employees.add(new Employee2("张三", 5000, new Birthdate(1990, 5, 15)));
        employees.add(new Employee2("李四", 6000, new Birthdate(1985, 8, 23)));
        employees.add(new Employee2("张三", 5000, new Birthdate(1990, 5, 15))); // Duplicate based on name and birthdate

        for (Employee2 employee : employees) {
            System.out.println(employee);
        }
    }
}
