package enum_;

public class EnumMethod {
    public static void main(String[] args) {
        Season2 autumn=Season2.AUTUMN;
        //枚举类详细信息
        System.out.println(autumn.toString());
        //枚举类的名字
        System.out.println(autumn.name());
        //枚举类的位置号,从0开始
        System.out.println(autumn.ordinal());
        //枚举类的所有常量
        Season2 []values=Season2.values();
        for(Season2 season:values){
            System.out.println(season);
        }
        //将字符串转化成枚举对象,要求字符串必须为已有常量,否则报错
        Season2 spring=Season2.valueOf("SPRING");
        //位置号的差 0-2=-2
        System.out.println(spring.compareTo(autumn));
    }
}
