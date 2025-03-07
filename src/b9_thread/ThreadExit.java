package b9_thread;

public class ThreadExit {
    public static void main(String[] args) {
        T t = new T();
        t.start();

        //主线程走10s后中断子线程
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setLoop(false);
    }
}
class T extends Thread{

    private int count=0;
    private boolean loop=true;
    @Override
    public void run(){
        while (loop){
            System.out.println(Thread.currentThread().getName()+" "+count++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void setLoop(boolean loop){
        this.loop=loop;
    }

}

