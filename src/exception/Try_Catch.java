package exception;

public class Try_Catch {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {//捕获异常类型
            //处理异常方式
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }finally {//无论如何都执行
            System.out.println("程序结束");
        }
    }
}
