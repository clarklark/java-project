package b1_OOP_high.abstract_;

public class TestTemplate {
    public static void main(String[] args) {
        new A().calculateTime();
        new B().calculateTime();
    }
}
abstract class Template{
    public abstract void job();
    public void calculateTime(){
        long begin=System.currentTimeMillis();
        job();
        long end=System.currentTimeMillis();
        System.out.println("运行时间:"+(end-begin)+"毫秒");
    }
}
class A extends Template{
    @Override
    public void job() {
        long num=0;
        for(long i=1;i<5000000;i++){
            num+=i;
        }
    }
}
class B extends Template{
    @Override
    public void job() {
        long num=1;
        for(long i=1;i<500000;i++){
            num*=i;
        }
    }
}
