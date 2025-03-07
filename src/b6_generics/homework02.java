package b6_generics;

import java.util.*;

public class homework02 {
    public static void main(String[] args) {

        DAT<User>dat=new DAT<>();
        dat.save("01",new User(1,23,"clark"));
        dat.save("02",new User(2,24,"jerry"));
        dat.save("03",new User(3,24,"jerry"));
        dat.update("02",new User(2,28,"tommy"));
        System.out.println(dat.list());
        System.out.println(dat.get("02"));
    }
}
class DAT<T>{
    Map<String,T>map=new HashMap<>();
    public void save(String id ,T entity){
        map.put(id,entity);
    }
    public T get(String id){
        return map.get(id);
    }
    public void update(String id,T entity){
        map.put(id,entity);
    }
    public List<T>list(){
        List<T>list=new ArrayList<>();
        Set <String>keySet=map.keySet();
        for (String key:keySet){
            list.add(map.get(key));
        }
        return list;
    }
    public void delete(String id){
        map.remove(id);
    }


}
class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}