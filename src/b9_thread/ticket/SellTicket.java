package b9_thread.ticket;

public class SellTicket {
    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        Thread t1 = new Thread(sellTicket01);
        Thread t2 = new Thread(sellTicket01);
        Thread t3 = new Thread(sellTicket01);
        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTicket01 implements Runnable {
    private static int ticketNum = 100;
    private boolean loop = true;

    public synchronized void sell() {

        if (ticketNum <= 0) {
            System.out.println("票已经售完了");
            loop = false;
            return;
        }
        System.out.println("窗口"+Thread.currentThread().getName()+"售出票一张"+"还剩票" + --ticketNum + "张");
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }

}
