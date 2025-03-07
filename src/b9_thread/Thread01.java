package b9_thread;

public class Thread01 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
        for (int i = 0; i < 60; i++) {
            System.out.println("程序继续执行" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Cat extends Thread {

    @Override
    public void run() {
        int times = 0;
        while (times != 80) {
            System.out.println("我是猫,喵喵喵" +Thread.currentThread().getName()+ times++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}