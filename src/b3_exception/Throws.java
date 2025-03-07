package b3_exception;

public class Throws {
    //提前预知会出现的异常,throws在类
    public static void main(String[] args) throws NullPointerException {
                String str = null;
                System.out.println(str.length());

    }

}
