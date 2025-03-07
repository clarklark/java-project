package b5_collection.set;

import java.util.HashSet;
@SuppressWarnings("all")
public class HashSet01 {
    public static void main(String[] args) {
        HashSet set=new HashSet();
        set.add("rick");//ok
        set.add("rick");//no
        set.add(new Dog("msg"));//ok
        set.add(new Dog("msg"));//ok

        System.out.println(set);
    }
}
class Dog{
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}