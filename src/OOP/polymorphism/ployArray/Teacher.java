package OOP.polymorphism.ployArray;

public class Teacher extends Person{
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher(String name, int age,double salary) {
        super(name, age);
        this.salary=salary;
    }
    public String say(){
        return ""+super.say()+" 工资:"+salary;
    }
    public void teach(){
        System.out.println(super.getName()+"正在教java");
    }
}
