package a2_OOP.improveExtends;
public class testExtends {
    public static  void main(String []args){
        a2_OOP.improveExtends.pupil pupil=new pupil();
        pupil.name="DuanZhe";
        pupil.age=12;
        pupil.testing();
        pupil.setScore(97);
        pupil.showInfo();
        a2_OOP.improveExtends.graduate gra=new graduate();
        gra.name="Jerry";
        gra.age=18;
        gra.testing();
        gra.setScore(100);
        gra.showInfo();
    }
}
