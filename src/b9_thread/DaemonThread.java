package b9_thread;

public class DaemonThread {
    public static void main(String[] args) {
        // 创建一个子线程
        Thread childThread = new Thread(new ChildThread());

        // 设置子线程为守护线程
        childThread.setDaemon(true);
        // 启动子线程
        childThread.start();

        // 主线程输出
        for (int i = 0; i < 10; i++) {
            System.out.println("旅行者在睡觉");
            try {
                // 主线程休眠一秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ChildThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("妮露和散兵在开心地***, 啊啊啊...");
            try {
                // 为了避免散兵输出太快，这里让他们休眠一秒
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
