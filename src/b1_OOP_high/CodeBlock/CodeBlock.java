package b1_OOP_high.CodeBlock;

public class CodeBlock {
    public static void main(String[] args) {

    Movie movie = new Movie("热辣滚烫");
}
}

class Movie {
    private String name;
    private double price;
    private String director;

    //有相同语句，可以将相同语句放到下一个代码块中
    {
        System.out.println("电影打开...");
        System.out.println("广告开始...");
        System.out.println("电影开始...");
    }

    public Movie(String name) {
        this.name = name;
        System.out.println("Movie 方法被调用");
    }

    public Movie(double price, String name) {
        this.price = price;
        this.name = name;
    }

    public Movie(String name, double price, String director) {
        this.name = name;
        this.price = price;
        this.director = director;
    }


}

