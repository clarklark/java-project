package OOP.polymorphism.ployparameter;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getAnnal() {
        return super.getAnnal() + bonus;
    }

    public void manage() {
        System.out.println(super.getName() + " is managing");
    }
}
