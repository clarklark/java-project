package OOP.polymorphism.ployArray;

public class poly_arr {
    public static void main(String []args){
        Person []person=new Person[5];
        person[0]=new Person("LiShowDin",50);
        person[1]=new Student("jerry",18,691);
        person[2]=new Student("MushroomBro",19,644);
        person[3]=new Teacher("Kacy",40,6000);
        person[4]=new Teacher("Joy",40,26000);
        for (int i=0;i<person.length;i++) {//等价于遍历person数组
            System.out.println(person[i].say());
            if(person[i] instanceof Student){
                Student student=(Student)person[i];
                student.study();//或者(Student)person[i].study
            }else if(person[i] instanceof Teacher){
                Teacher teacher=(Teacher)person[i];
                teacher.teach();
            }else{
                System.out.println("校长在演讲");
            }
        }
    }
}
