package b3_exception;

//五大运行时异常
public class RunTimeException_ {
    public static void main(String[] args) {
        // 1. NullPointerException
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }

        // 2. ArithmeticException
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // 3. ArrayIndexOutOfBoundsException
        try {
            int[] array = new int[5];
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 4. ClassCastException
        try {
            Object obj = new String("10");
            String str = (String) obj;
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: " + e.getMessage());
        }

        // 5. NumberFormatException
        try {
            int num = Integer.parseInt("abc");
            System.out.println("Parsed number: " + num);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
    }
}
