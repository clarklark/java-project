package b6_generics;

import java.util.*;

public class GenericsExercise {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Tom", 8));
        students.add(new Student("Rick", 18));
        students.add(new Student("Jerry", 18));
        for (Student student : students) {
            System.out.println(student);
        }
        Map<String, Student> hashMap = new HashMap<>();
        hashMap.put("Tom", new Student("Tom", 8));
        hashMap.put("Rick", new Student("Rick", 18));

        Set<Map.Entry<String, Student>> entrySet = hashMap.entrySet();
        for (Map.Entry<String, Student> next : entrySet) {
            System.out.println(next.getKey() + '-' + next.getValue());
        }

//        while(iterator.hasNext()){
//            Map.Entry<String,Student>next=iterator.next();
//            System.out.println(next.getKey()+'-'+next.getValue());
//        }
    }
}

class Student {
    private int age;
    private String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}