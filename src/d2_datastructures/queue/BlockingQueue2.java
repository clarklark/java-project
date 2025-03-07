package d2_datastructures.queue;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue2<E> {
    private final E[] arr;
    private int tail;
    private int head;
    private final AtomicInteger size = new AtomicInteger(0);

    private final ReentrantLock headLock = new ReentrantLock();
    private final ReentrantLock tailLock = new ReentrantLock();

    private final Condition headWaits = headLock.newCondition();
    private final Condition tailWaits = tailLock.newCondition();

    public BlockingQueue2(int capacity) {
        this.arr = (E[]) new Object[capacity];
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == arr.length;
    }

    private int size(){
        return size.get();
    }

    public void offer(E e) throws InterruptedException {
        int c;
        tailLock.lockInterruptibly();
        try {
            while (isFull()) {
                tailWaits.await();
            }
            arr[tail] = e;
            if (++tail == arr.length) {
                tail = 0;
            }
            c = size.getAndIncrement();//size++
            if(c + 1 < arr.length){
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }

        if (c == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
    }

    public E poll() throws InterruptedException {
        int c;
        E e;
        headLock.lockInterruptibly();
        try {
            while (isEmpty()) {
                headWaits.await();
            }
            e = arr[head];
            arr[head] = null;
            if (++head == arr.length) {
                head = 0;
            }
            c = size.getAndDecrement();//size--
            if(c > 1){
                headWaits.signal();
            }

        } finally {
            headLock.unlock();
        }


        if (c == arr.length) {
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return e;

    }


    public static void main(String[] args) throws InterruptedException {
        testBasicFunction();
        testBlockingOffer();
        testBlockingPoll();
        testMultiThread();
        testCircularBuffer();
        System.out.println("所有测试通过!");
    }

    private static void testBasicFunction() throws InterruptedException {
        BlockingQueue2<Integer> queue = new BlockingQueue2<>(3);
        System.out.println("1.基本功能");
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("出队序列:" + queue.poll() + ", " + queue.poll() + ", " + queue.poll()); // 1,2,3
        assert queue.isEmpty();
        System.out.println("1.基本入队出队测试通过!");
    }

    private static void testBlockingOffer() throws InterruptedException {
        BlockingQueue2<Integer> queue = new BlockingQueue2<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("2.队满后,尝试入队元素'4'...");

        new Thread(() -> {
            try {
                queue.offer(4);
            } catch (InterruptedException e) {
                System.out.println("Offer blocked as expected");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1); // Wait for queue to fill
        System.out.println("阻塞入队后队列长度:" + queue.size()); // Still 3

        queue.poll(); // Free space
        new Thread(() -> {
            try {
                queue.offer(4);
                System.out.println("2.一次出队后成功入队" + 4);

            } catch (InterruptedException e) {
                System.out.println("Unexpected interruption");
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(500);
        assert queue.size() == 1;
        System.out.println("2.阻塞入队通过!");
    }

    private static void testBlockingPoll() throws InterruptedException {
        BlockingQueue2<Integer> queue = new BlockingQueue2<>(3);

        System.out.println("3.尝试出队空队列...");

        new Thread(() -> {
            try {
                queue.poll();

            } catch (InterruptedException e) {
                System.out.println("Poll blocked as expected");
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("出队元素被阻塞");
        queue.offer(1);
        new Thread(() -> {
            try {
                System.out.println("出队新入队元素:" + queue.poll());

            } catch (InterruptedException e) {
                System.out.println("Unexpected interruption");
            }
        }).start();
        TimeUnit.MILLISECONDS.sleep(500);
        assert queue.isEmpty();
        System.out.println("3.出队阻塞测试通过!");
    }

    private static void testMultiThread() throws InterruptedException {
        BlockingQueue2<Integer> queue = new BlockingQueue2<>(3);
        int producerThreads = 5;
        int consumerThreads = 5;
        CountDownLatch startSignal = new CountDownLatch(1);

        // Producer tasks
        for (int i = 0; i < producerThreads; i++) {
            new Thread(() -> {
                try {
                    startSignal.await();
                    for (int j = 0; j < 10; j++) {
                        queue.offer(j);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        // Consumer tasks
        for (int i = 0; i < consumerThreads; i++) {
            new Thread(() -> {
                try {
                    startSignal.await();
                    for (int j = 0; j < 10; j++) {
                        queue.poll();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }

        startSignal.countDown();
        TimeUnit.SECONDS.sleep(5); // Allow time to process

        System.out.println("队列最终大小:" + queue.size()); // Expected 0
        assert queue.isEmpty() : "多线程测试未通过!";
        System.out.println("4.多线程测试通过!");
    }

    private static void testCircularBuffer() throws InterruptedException {
        BlockingQueue2<Integer> queue = new BlockingQueue2<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.poll(); // head=1, tail=0
        queue.offer(4);
        System.out.println("环绕数组后: head=" + queue.head + ", tail=" + queue.tail);
        assert queue.size() == 3;
        System.out.println("出队元素序列:" + queue.poll() + ", " + queue.poll() + ", " + queue.poll()); // 2,3,4
        assert queue.isEmpty();
        System.out.println("5.环绕数组测试通过!");
    }
}