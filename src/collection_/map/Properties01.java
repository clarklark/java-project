package collection_.map;

import java.util.Properties;

public class Properties01 {
    public static void main(String[] args) {
        //继承HashTable
        //k-v不能同时为空
        Properties properties=new Properties();
        properties.put("no.1","nigger");
        properties.put("no.2","rick strong");
        System.out.println(properties);
        System.out.println(properties.get("no.1"));
        properties.remove("no.1");
        System.out.println(properties.getProperty("no.2"));

    }
}
