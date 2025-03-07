package b5_collection.set;

import java.util.LinkedHashSet;
import java.util.Objects;

@SuppressWarnings("all")
public class LinkedHashSet01 {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet=new LinkedHashSet();
        linkedHashSet.add(new Car("aodi",1300));
        linkedHashSet.add(new Car("byd",10));
        linkedHashSet.add(new Car("byd",10));//加入不了
        linkedHashSet.add(new Car("fll",300));
        linkedHashSet.add(new Car("fengtian",13));
        System.out.println(linkedHashSet);
    }
}
class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                "}";
    }
/*重写equals和hashCode方法
   name和price相同时,返回相同hash值
   保证name和price相同的元素不能加入
 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(price, car.price) == 0 && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}