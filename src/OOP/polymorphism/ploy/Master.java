package OOP.polymorphism.ploy;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Animal animal, Food food) {
        //animal的编译类型是Animal，可以指向（接受）Animal子类的对象
        System.out.println("主人" + name + "正在给" + animal.getName() + "喂" + food.getName());
    }
}
