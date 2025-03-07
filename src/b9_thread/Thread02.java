package b9_thread;

public class Thread02 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}

class T1 implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count <= 10) {
            System.out.println("hello " + count+++" "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class T2 implements Runnable {
    @Override
    public void run() {
        int count = 0;
        while (count <= 10) {
            System.out.println("hi " + count+++" "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}