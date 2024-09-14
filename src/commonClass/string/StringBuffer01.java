package commonClass.string;

@SuppressWarnings("all")
public class StringBuffer01 {
    public static void main(String[] args) {
        //StringBuffer的字符存储在char[]value,所以在变化时,不用每次都更换地址(创建对象)
        //效率远远高于String

        StringBuffer sb=new StringBuffer("hello");
        //1.append
        sb.append(",").append(true).append("jerry");
        System.out.println(sb);
        //2.delete,删去[6,10)
        sb.delete(6,10);
        System.out.println(sb);
        //3.replace,代替[6,10)
        sb.replace(6,11,"rick");
        System.out.println(sb);
        //4.indexOf
        System.out.println(sb.indexOf("clark"));
        //5.insert
        sb.insert(6,"my son  ");
        System.out.println(sb);
        //6.length
        System.out.println(sb.length());
    }
}
