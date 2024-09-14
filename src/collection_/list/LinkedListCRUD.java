package collection_.list;

import java.util.LinkedList;
@SuppressWarnings("all")
public class LinkedListCRUD {
    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList();
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);

        System.out.println(linkedList);

        //删除第一个
        linkedList.remove();
        linkedList.remove(0);
        System.out.println(linkedList);
        linkedList.set(0,"jjb");
        System.out.println(linkedList);
    }
}
