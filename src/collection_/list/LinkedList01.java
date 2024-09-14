package collection_.list;

public class LinkedList01 {
    public static void main(String[] args) {
        Node clark = new Node("clark");
        Node rick = new Node("rick");
        Node tom = new Node("tom");
        //clark->rick->tom
        clark.next = rick;
        rick.next = tom;
        Node first = clark;
        //tom->rick->clark
        tom.pre = rick;
        rick.pre = clark;
        Node last = tom;

        System.out.println("===头节点遍历===");
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }

        System.out.println("===尾节点遍历===");
        while (last != null) {
            System.out.println(last);
            last = last.pre;
        }

        //插入新节点
        Node jerry = new Node("jerry");
        jerry.pre = clark;
        jerry.next = rick;
        clark.next = jerry;
        rick.pre = jerry;

        //重置头节点
        first = clark;
        System.out.println("===插入后头节点遍历===");
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }
        //重置尾节点
        last = tom;
        System.out.println("===插入后尾节点遍历===");
        while (last != null) {
            System.out.println(last);
            last = last.pre;
        }

        //删除节点
        jerry.next = tom;
        tom.pre = jerry;
        //重置头节点
        first = clark;
        System.out.println("===删除后头节点遍历===");
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }
        //重置尾节点
        last = tom;
        System.out.println("===删除后尾节点遍历===");
        while (last != null) {
            System.out.println(last);
            last = last.pre;
        }

        //修改节点
        Node kobe = new Node("kobe");
        clark.next = kobe;
        tom.pre = kobe;
        kobe.next = tom;
        kobe.pre = clark;
        //重置头节点
        first = clark;
        System.out.println("===修改后头节点遍历===");
        while (first != null) {
            System.out.println(first);
            first = first.next;
        }
        //重置尾节点
        last = tom;
        System.out.println("===修改后尾节点遍历===");
        while (last != null) {
            System.out.println(last);
            last = last.pre;
        }
    }
}

class Node {
    public Node next;
    public Object data;
    public Node pre;

    public Node(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
