package b9_thread;

public class ThreadMethod {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.start();
        for(int i=1;i<20;i++){
            System.out.println("主线程(小弟)吃了"+i+"个");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(i==5){
                System.out.println("小弟让老大先吃");
                try {
                    t3.join();//插队一定成功
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("老大吃够了,小弟接着吃");
            }
        }
    }
}
class T3 extends Thread{
    @Override
    public void run(){
        for(int i=1;i<20;i++){
            System.out.println("子线程(老大)吃了"+i+"个");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}

