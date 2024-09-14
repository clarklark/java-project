package OOP.polymorphism.ployparameter;

public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println(super.getName() + " is working");
    }

    public double getAnnal() {
        return super.getAnnal();
    }

}
