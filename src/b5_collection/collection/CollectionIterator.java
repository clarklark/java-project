package b5_collection.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@SuppressWarnings("all")
public class CollectionIterator {
    public static void main(String[] args) {
        Collection col=new ArrayList();
        col.add(new Book("三国演义","罗贯中",23.3));
        col.add(new Book("水浒传","施耐庵",19.1));
        col.add(new Book("红楼梦","曹雪芹",25.7));

        Iterator iterator=col.iterator();
        while(iterator.hasNext()){
            Object obj= iterator.next();
            System.out.println("obj="+obj);
        }
        //再次遍历需要重置
        System.out.println("===第二次遍历===");
         iterator=col.iterator();
        while(iterator.hasNext()){
            Object obj= iterator.next();
            System.out.println("obj="+obj);
        }

        System.out.println("===增强遍历===");
        iterator=col.iterator();
        for(Object book:col){
            System.out.println(book);
        }
    }
}
class Book{
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
