package b2_enum;

public class EnumDetails {
}
interface Spring{
   void playing();
}
//enum 关键字不能继承类,但可以实现接口
enum Season3 implements Spring{
    ;
    @Override
    public void playing() {

    }
}