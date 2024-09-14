package commonClass.string;

@SuppressWarnings("all")
public class StringAndStringBuffer {
    public static void main(String[] args) {
        //String->StringBuffer
        String str="hello";
        //1.构造器
        StringBuffer sb1=new StringBuffer(str);
        //2.append
        StringBuffer sb2=new StringBuffer();
        sb2.append(str);

        //StringBuffer->String
        //1.toString
        StringBuffer sb3=new StringBuffer("java");
        String str2=sb3.toString();
        //2.构造器
        String str3=new String(sb3);

    }
}
