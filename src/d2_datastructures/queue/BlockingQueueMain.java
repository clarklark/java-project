package d2_datastructures.queue;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueMain {
    private String[] arr;
    private int tail = 0;
    private int head = 0;
    private int size = 0;
    ReentrantLock lock = new ReentrantLock();
    Condition headWaits = lock.newCondition();//队头,控制出
    Condition tailWaits = lock.newCondition();//队尾,控制入

    public BlockingQueueMain(int capacity) {
        arr = new String[capacity];
    }

    private void offer(String e) throws InterruptedException {
        lock.lockInterruptibly();//加锁,可以在阻塞过程中随时打断
        try {
            while (isFull()) {
                tailWaits.await();//当前线程加入tailWaits,并且让此线程阻塞
            }
            arr[tail] = e;
            if (++tail == arr.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
        } finally {
            lock.unlock();
        }
    }

    private boolean offer(String e, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            long t = TimeUnit.MILLISECONDS.toNanos(timeout);//用于控制最大等待时间,时间到了队列没移除就不管新插入了
            while (isFull()) {
                if (t <= 0) {
                    return false;
                }
                t = tailWaits.awaitNanos(t);
            }
            arr[tail] = e;
            if (++tail == arr.length) {
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        } finally {
            lock.unlock();
        }
    }

    private String poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            String e = arr[head];
            arr[head] = null;
            if (++head == arr.length) {
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }

    private boolean isFull() {
        return size == arr.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "queue:{" + Arrays.toString(arr) +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueueMain queue = new BlockingQueueMain(3);
        Thread t1 = new Thread(() -> {
            try {
                long start = System.currentTimeMillis();
                System.out.println(start + "开始");
                queue.offer("任务1");
                System.out.println(queue);
                queue.offer("任务2");
                System.out.println(queue);
                queue.offer("任务3");
                System.out.println(queue);
                queue.offer("任务4", 2000);
                System.out.println(queue);
                long end = System.currentTimeMillis();
                System.out.println(end + "结束");
                System.out.println("耗时" + (end - start) + "ms");
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }, "生产者");
        t1.start();

        Thread.sleep(2000);

        queue.poll();
    }
}
