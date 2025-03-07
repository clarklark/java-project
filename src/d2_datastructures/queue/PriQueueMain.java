package d2_datastructures.queue;

/**
 * 优先级队列,按照优先级出队列
 */
public class PriQueueMain {
    public static void main(String[] args) {
        PriorityQueueArr<Element> queue = new PriorityQueueArr<>(5);
        queue.offer(new Element("plm", 1));
        queue.offer(new Element("sdl", 8));
        System.out.println(queue.poll().name + " " + queue.peek().name);
        PriorityQueueMaxHeap<Element> queueHeap = new PriorityQueueMaxHeap<>(2);
        queueHeap.offer(new Element("task1", 2));
        queueHeap.offer(new Element("task2", 10));
        System.out.println(queueHeap.poll().name + " " + queueHeap.peek().name);
        PriorityQueueMinHeap<Element> queueMinHeap = new PriorityQueueMinHeap<>(2);
        queueMinHeap.offer(new Element("task1", 21));
        queueMinHeap.offer(new Element("task2", 10));
        System.out.println(queueMinHeap.poll().name + " " + queueMinHeap.peek().name);
    }
}

interface Priority {
    int priority();
}

class Element implements Priority {
    String name;
    int priorityValue;

    public Element(String name, int priorityValue) {
        this.name = name;
        this.priorityValue = priorityValue;
    }

    @Override
    public int priority() {
        return priorityValue;
    }
}

/**
 *基于无序数组实现优先队列
 */
class PriorityQueueArr<E extends Priority> {
    Priority[] arr;
    int size;

    public PriorityQueueArr(int capacity) {
        arr = new Priority[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }


    public boolean offer(E e) {
        if (isFull()) {
            return false;
        }
        arr[size++] = e;
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        E e = (E) arr[max];
        remove(max);
        return e;

    }

    private void remove(int index) {
        if (index < size - 1) {
            System.arraycopy(arr, index + 1
                    , arr, index, size - 1 - index);
        }
        size--;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        int max = selectMax();
        return (E) arr[max];
    }

    public int selectMax() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i].priority() > arr[max].priority()) {
                max = i;
            }
        }
        return max;
    }
}

/**
 *基于大顶堆实现优先队列,优先级数值高的优先出队
 */
class PriorityQueueMaxHeap<E extends Priority> {
    Priority[] arr;
    int size;

    public PriorityQueueMaxHeap(int capacity) {
        arr = new Priority[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }

        int child = size++;
        int parent = (child - 1) / 2;
        while (child > 0 && offered.priority() > arr[parent].priority()) {
            arr[child] = arr[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        arr[child] = offered;
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        Priority e = arr[--size];
        arr[size] = null;
        down(0);
        return (E) e;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) arr[0];
    }

    public void swap(int i, int j) {
        Priority t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && arr[left].priority() > arr[max].priority()) {
            max = left;
        }
        if (right < size && arr[right].priority() > arr[max].priority()) {
            max = right;
        }
        if (max != parent) {//有孩子比父亲大
            swap(max, parent);
            down(max);
        }
    }
}
/**
 *基于小顶堆实现优先队列,优先级数值低的优先出队
 */
class PriorityQueueMinHeap<E extends Priority> {
    Priority[] arr;
    int size;

    public PriorityQueueMinHeap(int capacity) {
        arr = new Priority[capacity];
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer(E offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        Priority e = arr[child];
        while (child > 0 && offered.priority() < arr[parent].priority()) {
            arr[child] = arr[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        arr[child] = offered;
        return true;
    }

    public E poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        Priority e = arr[--size];
        arr[size] = null;
        down(0);
        return (E) e;
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) arr[0];
    }

    public void swap(int i, int j) {
        Priority t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;
        if (left < size && arr[left].priority() < arr[min].priority()) {
            min = left;
        }
        if (right < size && arr[right].priority() < arr[min].priority()) {
            min = right;
        }
        if (min != parent) {
            swap(min, parent);
            down(min);
        }

    }

}

