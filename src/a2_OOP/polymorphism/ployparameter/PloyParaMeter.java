package a2_OOP.polymorphism.ployparameter;

public class PloyParaMeter {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 10000);
        Manager clark = new Manager("clark", 30000, 240000);
        PloyParaMeter ppm = new PloyParaMeter();
        ppm.showEmpAnnal(tom);
        ppm.showEmpAnnal(clark);
        ppm.testWork(tom);
        ppm.testWork(clark);
    }

    public void showEmpAnnal(Employee e) {
        System.out.println(e.getName() + "的年薪是" + e.getAnnal());
    }

    public void testWork(Employee e) {
        if (e instanceof Worker) {
            ((Worker) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        } else {
            System.out.println("您输入的类型有误");
        }
    }
}
