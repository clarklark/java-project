package c3_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Reflect02 {
    public static void main(String[] args) throws Exception{
        Class<Student> studentClass = Student.class;
        Field nameFiled = studentClass.getDeclaredField("name");
        Field ageFiled = studentClass.getDeclaredField("age");
        ageFiled.setAccessible(true);
        nameFiled.setAccessible(true);

        Constructor<Student> constructor = studentClass.getConstructor();
        Student stu1 = constructor.newInstance();
        Student stu2 = constructor.newInstance();

        ageFiled.set(stu1,23);
        nameFiled.set(stu2,"Dijkstra");

        System.out.println("stu1:"+stu1.age+"\n"+"stu2"+stu2.name);


    }
}
