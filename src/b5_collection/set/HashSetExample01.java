package b5_collection.set;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings("all")
public class HashSetExample01 {
    public static void main(String[] args) {
        HashSet hashSet=new HashSet();
        hashSet.add(new Employee("jerry",18));
        hashSet.add(new Employee("rick",18));
        hashSet.add(new Employee("jerry",18));

        System.out.println(hashSet);


    }
}
class Employee{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}