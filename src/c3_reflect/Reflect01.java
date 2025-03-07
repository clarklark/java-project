package c3_reflect;

import java.lang.reflect.Constructor;

public class Reflect01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<Student> studentClass = Student.class;

        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        System.out.println("遍历");
        for(Constructor de:declaredConstructors){
            System.out.println(de);
        }

        System.out.println("选择构造器");
        Constructor<Student> constructor0 = studentClass.getConstructor();
        Constructor<Student> constructor1 = studentClass.getConstructor(String.class, int.class, double.class);
        System.out.println(constructor0+"\n"+constructor1);
    }

    private static Class<Student> getaClass() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("c3_reflect.Student");

        Class<Student> studentClass = Student.class;

        Student student = new Student();
        Class<? extends Student> aClass1 = student.getClass();
        System.out.println("3种");
        System.out.println(aClass+"\n" +studentClass+"\n"+aClass1);
        return studentClass;
    }
}
class Student {
    String name;
    int age;
    double GPA;

    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }
}
