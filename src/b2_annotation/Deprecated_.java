package b2_annotation;

import java.lang.*;

public class Deprecated_ {
    public static void main(String[] args) {

    }
}

//用@Deprecated修饰,表示该 方法/类/字段/包/参数 过时了
//可以用于版本升级过渡使用
@Deprecated
class A{
    public void say(){
        System.out.println("Mamba out!");
    }

}