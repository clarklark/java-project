package b6_generics;

import java.util.ArrayList;
import java.util.Comparator;

public class homework {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 1800, new MyDate(2004, 8, 13)));
        employees.add(new Employee("jerry", 8800, new MyDate(2005, 5, 31)));
        employees.add(new Employee("jerry", 8800, new MyDate(2005, 5, 30)));
        System.out.println("==排序前==");
        System.out.println(employees);
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                int nameCmp = emp1.getName().compareTo(emp2.getName());
                if (nameCmp != 0) {
                    return nameCmp;
                } else {
                    return emp1.getMyDate().compareTo(emp2.getMyDate());
                }
            }
        });
        System.out.println("==排序后==");
        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private double sal;
    private MyDate brithDay;

    public Employee(String name, double sal, MyDate brithDay) {
        this.name = name;
        this.sal = sal;
        this.brithDay = brithDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getMyDate() {
        return brithDay;
    }

    public void setMyDate(MyDate brithDay) {
        this.brithDay = brithDay;
    }

    @Override
    public String toString() {
        return '\n'+"Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", brithDay=" + brithDay +
                '}' ;
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int compareTo(MyDate myDate) {
        int yearCmp = this.year - myDate.getYear();
        int monthCmp = this.month - myDate.getMonth();
        if (yearCmp != 0) {
            return yearCmp;
        } else if (monthCmp != 0) {
            return monthCmp;
        } else {
            return this.day - myDate.getDay();
        }
    }
}