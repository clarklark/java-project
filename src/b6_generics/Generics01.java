package b6_generics;

import java.util.ArrayList;

@SuppressWarnings("all")
public class Generics01 {
    public static void main(String[] args) {
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("rick"));
        arrayList.add(new Dog("jerry"));
//      arrayList.add(new Cat("tom"));使用泛型后运行时异常转为编译异常

    }
}

class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public Dog(String name) {
        this.name = name;
    }
}

class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public Cat(String name) {
        this.name = name;
    }
}