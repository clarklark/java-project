package b2_enum;

/**
 * 自定义枚举类
 */
public class Enumeration01 {
    public static void main(String[] args) {

        System.out.println(Season.SPRING);
    }
}
class Season{
    private String name;
    private String describe;
    private Season(String name,String describe){
        this.name=name;
        this.describe=describe;
    }
    public static final Season SPRING=new Season("Spring","Warm");
    public static final Season SUMMER=new Season("Summer","Hot");
    public static final Season AUTUMN=new Season("Autumn","Cool");
    public static final Season WINTER=new Season("Winter","Cold");

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}