package commonClass.string;

public class String01 {
    public static void main(String[] args) {
        //1.equals 比较
        String s1="boss";
        String s2="Boss";
        System.out.println(s1.equals(s2));
        //2.equalsIgnoreCase 比较,忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
        //3.length 字符串长度
        System.out.println(s1);
        //4.indexOf 某个字符第一次出现的索引
        System.out.println(s1.indexOf("s"));
        //5.lastIndexOf 某个字符最后出现的索引
        System.out.println(s1.indexOf("s"));
        //6.substring(n)从某索引n开始截取后面的
        System.out.println(s1.substring(2));
        //substring(n,m)从索引n开始截取到索引m-1
        System.out.println(s1.substring(0,3));

    }
}
