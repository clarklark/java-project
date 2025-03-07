package d2_datastructures.queue;

import java.util.Iterator;

public class QueueMain {
    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer element : queue) {
            System.out.println(element);
        }
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(3);
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        arrayQueue.poll();
        for (Integer ele : arrayQueue) {
            System.out.println(ele);
        }

    }
}

/**
 *链表实现队列
 */
class LinkedListQueue<E> implements Iterable<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int capacity;

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
        this.head = new Node<>(null, null);
        this.tail = head;
    }

    public LinkedListQueue() {
        this.capacity = Integer.MAX_VALUE;
        this.head = new Node<>(null, null);
        this.tail = head;
    }

    //头插入
    public boolean offer(E e) {
        if (size == capacity) {
            return false;
        }
        Node<E> added = new Node<>(e, null);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    //尾删除,获取删除元素
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first.next == null) {
            tail = head;
        }
        size--;
        return first.value;
    }
    //获取头元素
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = head.next;

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


@SuppressWarnings("all")
/**
 * 数组实现队列
 */
class ArrayQueue<E> implements Iterable<E> {
    private E[] arr;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public ArrayQueue(int capacity) {
        arr = (E[]) new Object[capacity + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    //尾插入
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        arr[tail] = value;
        tail = (tail + 1) % arr.length;
        size++;
        return true;
    }
    //头删除
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = arr[head];
        head = (head + 1) % arr.length;
        size--;
        return value;
    }
    //头元素
    public E peek(){
        if (isEmpty()) {
            return null;
        }
        return arr[head];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public E next() {
                E value = arr[p];
                p = (p + 1) % arr.length;
                count++;
                return value;
            }
        };
    }
}


@SuppressWarnings("all")
class ArrayQueue1<E> implements Iterable<E> {
    private final E[] arr;
    private int head = 0;
    private int tail = 0;


    public ArrayQueue1(int capacity) {
        arr = (E[]) new Object[capacity + 1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return tail - head == arr.length;
    }

    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        arr[tail % arr.length] = value;
        tail++;
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E value = arr[head % arr.length];
        head++;
        return value;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return arr[head % arr.length];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E value = arr[p % arr.length];
                p++;
                return value;
            }
        };
    }
}