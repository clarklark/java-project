package d2_datastructures.stack;

import java.util.Iterator;

public class StackMain {
    public static void main(String[] args) {

        LinkedListStack<Integer> linkedListStack=new LinkedListStack<>(3);
        ArrayStack<Integer> arrayStack=new ArrayStack<>(3);
        linkedListStack.push(2);
        linkedListStack.push(3);
        linkedListStack.push(4);

        arrayStack.push(6);
        arrayStack.push(7);
        arrayStack.push(8);
        System.out.println(arrayStack.isFull()+" "+linkedListStack.isFull());
        for(Integer ele:linkedListStack){
            System.out.println(ele);
        }
        System.out.println();
        for(Integer ele:arrayStack){
            System.out.println(ele);
        }

    }
}

/**
 * 链表实现栈
 */
class LinkedListStack<E> implements Iterable<E> {

    static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int size = 0;
    private final int capacity;
    private final Node<E> head = new Node<>(null, null);

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    //头插入
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        head.next = new Node<>(value, head.next);
        size++;
        return true;
    }

    //头删除,返回头元素
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        head.next = head.next.next;
        size--;
        return head.next.value;
    }

    //返回头元素
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;

                return value;
            }
        };
    }


}

/**
 * 数组实现栈
 */
class ArrayStack<E>implements Iterable<E> {
    private E[]arr;
    private int top=0;
    private int capacity;
    public ArrayStack(int capacity){
        this.arr= (E[]) new Object[capacity];
    }
    public boolean isEmpty(){
        return top==0;
    }
    public boolean isFull(){
        return top==arr.length;
    }
    //头插入
    public boolean push(E value){
        if(isFull()){
            return false;
        }
        arr[top++]=value;
        return true;
    }
    //头删除,返回头
    public E pop(){
        if(isEmpty()){
            return null;
        }
        return arr[--top];

    }
    //获取头元素
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return arr[top-1];

    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p=top;
            @Override
            public boolean hasNext() {
                return p>0;
            }

            @Override
            public E next() {
                return arr[--p];
            }
        };
    }
}
