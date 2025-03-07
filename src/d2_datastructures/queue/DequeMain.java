package d2_datastructures.queue;

import java.util.Iterator;

/**
 * 双端队列
 */

public class DequeMain {
    public static void main(String[] args) {

    }
}

@SuppressWarnings("all")
class ArraysDeque<E> implements Iterable<E> {

    static int inc(int i, int length) {
        if (i + 1 >= length) {
            return 0;
        }
        return i + 1;
    }

    static int dec(int i, int length) {
        if (i - 1 <= 0) {
            return length - 1;
        }
        return i - 1;
    }

    E[] arr;
    int head;
    int tail;

    public ArraysDeque(int capacity) {
        arr = (E[]) new Object[capacity + 1];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        if (tail > head) {
            return head - tail == arr.length - 1;
        } else if (tail < head) {
            return head - tail == 1;
        } else {
            return false;
        }

    }

    public boolean offerFirst(E value) {
        if (isFull()) {
            return false;
        }
        head = dec(head, arr.length);
        arr[head] = value;
        return true;
    }

    public boolean offerLast(E vlaue) {
        if (isFull()) {
            return false;
        }
        arr[tail] = vlaue;
        tail = inc(tail, arr.length);
        return true;
    }

    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        E value = arr[head];
        arr[head] = null;// help GC
        head = inc(head, arr.length);
        return value;
    }

    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        tail = dec(tail, arr.length);
        E value = arr[tail];
        arr[tail] = null;//help GC
        return value;
    }

    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return arr[head];
    }

    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return arr[tail];
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p=head;
            @Override
            public boolean hasNext() {
                return p!=tail;
            }

            @Override
            public E next() {
                E value=arr[p];
                p=inc(p,arr.length);
                return value;
            }
        };
    }
}
