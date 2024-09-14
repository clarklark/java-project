package exception;


public class CustomException {
    public static void main(String[] args) {
    int age=19;
    if(age>80||age<18){
        throw new AgeException("年龄需要在18-80之间");
    }
        System.out.println("你的年龄正确");
    }
}
//自定义异常
class AgeException extends RuntimeException{
     public AgeException(String message){
        super(message);
    }
}
