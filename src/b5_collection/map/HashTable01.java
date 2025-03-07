package b5_collection.map;

import java.util.Hashtable;

@SuppressWarnings("all")
public class HashTable01 {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("clark", "nui");
        // table.put("clark",null);空指针异常
        // table.put(null,"nui");
        table.put(1,"hello");
        table.put(2,"hello");
        table.put(3,"hello");
        table.put(4,"hello");
    }
}
