package commonClass.wrapper;

public class WrapperVsString {
    public static void main(String[] args) {
        //1.Integer->String
        int i = 10;
        //方法1
        String str1 = i + "";
        //方法2 jdk21不能用
        // String str2=i.toString();
        //方法3
        String str3 = String.valueOf(i);

        //2.String->Integer
        String strInt = "123";
        //方法1
        Integer n1 = Integer.parseInt(strInt);
        //方法2 jdk21不能用
        //Integer n2 = new Integer(strInt);
    }
}
