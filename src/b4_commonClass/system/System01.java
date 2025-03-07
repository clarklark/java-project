package b4_commonClass.system;


import java.util.Arrays;

public class System01 {
    public static void main(String[] args) {
        //1.exit(0) 0代表退出
        System.out.println("ok");
        //System.exit(0);
        System.out.println("hello");

        //2.System.arraycopy
        // (原数组,原数组开始拷贝的索引,新数组,新数组开始拷贝的索引,拷贝元素个数)
        int[]scr={1,2,3};
        int[]dest=new int[3];

        System.arraycopy(scr,1,dest,0,2);
        System.out.println(Arrays.toString(dest));

    }
}
