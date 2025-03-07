package d2_datastructures.linkedList;

public class LinkedList_Main {
    public static void main(String[] args) {
        SinglyLinkedList sList = new SinglyLinkedList();
        DoublyLinkedList dList = new DoublyLinkedList();
        dList.addFirst(2);
        dList.addLast(4);
        dList.insert(5, 1);
        dList.remove(-1);
        dList.loop();

    }
}

/**
 * 单链表
 */
class SinglyLinkedList {
    //哨兵节点
    private Node head = new Node(114514, null);

    public static class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        Node p = head;
        int i = 0;
        while (p.next != null) {
            p = p.next;
            i++;
        }
        return i;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    public void loop() {
        Node p = head.next;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }
    }

    private Node findLast() {
        return findNode(size() - 1);
    }

    private Node findNode(int index) {
        if (index<0||index>=size()){
            throw new IllegalArgumentException("索引不合法");
        }
        int i = -1;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    public int get(int index) {
        if (index<0||index>=size()){
            throw new IllegalArgumentException("索引不合法");
        }
        Node node = findNode(index);
        return node.value;
    }

    public void insert(int index, int value) {
        if (index<0||index>=size()){
            throw new IllegalArgumentException("索引不合法");
        }
        Node pre = findNode(index - 1);
        pre.next = new Node(value, pre.next);
    }

    public void removeFirst() {
        remove(0);
    }

    public void remove(int index) {
        if (index<0||index>=size()){
            throw new IllegalArgumentException("索引不合法");
        }
        Node pre = findNode(index - 1);
        pre.next = pre.next.next;
    }

    private static IllegalArgumentException illegalArgumentException(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }
}

/**
 * 双向链表
 */
class DoublyLinkedList {
    private Node head;
    private Node tail;

    class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public DoublyLinkedList() {
        head = new Node(114514, null, null);//头哨兵
        tail = new Node(1919810, null, null);//尾哨兵
        head.next = tail;
        tail.prev = head;
    }

    public int size() {
        Node p = head;
        int i = 0;
        while (p.next != tail) {
            p = p.next;
            i++;
        }
        return i;
    }

    public Node findNode(int index) {
        Node p = head;
        int i = -1;
        while (p != tail) {
            if (i == index) {
                return p;
            }
            i++;
            p = p.next;
        }
        return null;
    }

    public Node findLast() {
        return findNode(size() - 1);
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size()) {
            System.out.println("插入索引不合法");
            return;
        }
        Node prev = findNode(index - 1);
        Node p = new Node(value, prev.next, prev);
        Node next = prev.next;
        next.prev = p;
        prev.next = p;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void addLast(int value) {
        insert(size(), value);

    }

    public void remove(int index) {
        if (index < 0 || index > size()) {
            System.out.println("删除索引不合法");
            return;
        }
        Node prev = findNode(index - 1);
        Node p = findNode(index);
        Node next = p.next;
        prev.next = next;
        next.prev = prev;
    }

    public void loop() {
        Node p = head;
        while (p.next != tail) {
            p = p.next;
            System.out.println(p.value);
        }
    }
}
class CircleDoublyLinkedList{
    private Node sentinel=new Node(32425926,null,null);
    class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    public CircleDoublyLinkedList(){
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
    }
    public int size(){
        int i =0;
        Node p=sentinel;
        while (p.next!=sentinel){
            p=p.next;
            i++;
        }
        return i;
    }
    public Node findNode(int index){
        Node p=sentinel;
        int i=-1;
        while(p.next!=sentinel){
            if(i==index){
                return p;
            }
            p=p.next;
            i++;
        }
        return null;
    }
    public void insert(int index,int value){


    }
    public void remove(int index){

    }

}
