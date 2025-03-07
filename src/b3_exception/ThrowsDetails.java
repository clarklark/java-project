package b3_exception;

public class ThrowsDetails {
    public static void main(String[] args) {
        //1.对于编译异常,程序必须处理,比如用try-catch和throws
        //2.对于运行时异常,如果没有异常处理,默认处理方式是throws


    }
}

//3.子类重写父类方法时,抛出的异常要么与父类一致,要么为父类异常的子类
class Son extends Father {
    @Override
    public void eat() throws NumberFormatException{
        System.out.println("rice");
    }
}
class Father {
    public void eat() throws RuntimeException{
        System.out.println("fish");
    }

}