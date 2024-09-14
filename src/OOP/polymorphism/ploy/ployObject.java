package OOP.polymorphism.ploy;

public class ployObject {
    public static void main(String[] args) {
        //编译类型         运行类型
        Master master = new Master("clark");
        Animal animal = new Cat("jerry");//向上转型
        Food bone = new Bone("bone");
        master.feed(animal, bone);
        Cat cat=(Cat)animal;//向下转型 cat的编译类型和运行类型均为Cat
        cat.catchMouse();//前提原先animal对应Cat
    }
}
