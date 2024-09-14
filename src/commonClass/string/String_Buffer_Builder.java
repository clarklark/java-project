package commonClass.string;

public class String_Buffer_Builder {
    public static void main(String[] args) {
        //1.String  不可变字符序列 效率最低
        //2.StringBuffer  可变字符序列 效率较高 线程安全
        //3.StringBuilder  可变字符序列效率最高 线程不安全
        String s = "jerry";


        long start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s += " sex ";
        }
        long end = System.currentTimeMillis();
        System.out.println("String构建时间" + (end-start)+"ms");

        StringBuffer sf = new StringBuffer("rick");
        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            sf.append(" sex ");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer构建时间" + (end-start)+"ms");

        StringBuilder sd = new StringBuilder("tom");
        start = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            sd.append(" sex ");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder构建时间" +(end-start)+"ms");

        //字符串需要大量修改,单线程StringBuilder,多线程StringBuffer
        //字符串只需要很少修改,被多个对象应用,用String,如配置信息
    }
}
