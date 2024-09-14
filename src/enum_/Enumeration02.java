package enum_;

/**
 * 枚举类
 */
public class Enumeration02 {
    public static void main(String[] args) {
        System.out.println(Season2.AUTUMN);
    }
}
enum Season2{
    SPRING("Spring","Warm"),
    SUMMER("Summer","Hot"),
    AUTUMN("Autumn","Cool"),
    WINTER("Winter","Cold");;
    private String name;
    private String describe;

   private Season2(String name, String describe) {
        this.name = name;
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Season2{" +
                "name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                '}';
    }
}