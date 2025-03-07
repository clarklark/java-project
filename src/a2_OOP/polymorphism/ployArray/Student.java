package a2_OOP.polymorphism.ployArray;

public class Student extends Person{
    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, int age,double score) {
        super(name, age);
        this.score=score;
    }
    public String say(){
        return "学生 "+super.say()+"成绩:"+score;
    }
    public void study(){
        System.out.println(super.getName()+"正在学java");
    }
}
