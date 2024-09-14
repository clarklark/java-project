package commonClass.string;

public class String02 {
    public static void main(String[] args) {
        //1.toUpperCase
        String s1="clark";
        System.out.println(s1.toUpperCase());
        //2.toLowerCase
        String s2="ToM";
        System.out.println(s2.toUpperCase());
        //3.concat
        String s3=s1.concat(" eat ").concat(s2);
        System.out.println(s3);
        //4.replace
        String kobe="basketball and basketball";
        System.out.println(kobe.replace("basket","foot"));
        //5.spilt
        String Lao="Man!Haha haha ha!What can I say!?Mamba out!";
        String []Da=Lao.split("!");
        for (String s : Da) {
            System.out.println(s);
        }
        //6.toCharArray
        char []Man=Lao.toCharArray();
        for(char c:Man){
            System.out.println(c);
        }
        //7.compareTo
        String str1="jk";
        String str2="kj";
        System.out.println(str1.compareTo(str2));
        //8.format
        String name="Rick";
        char gander='男';
        double age=20.0;
        String formatStr="我的名字是%s,性别是%c,年龄是%.2f";
        String info=String.format(formatStr,name,gander,age);
        System.out.println(info);


    }
}
