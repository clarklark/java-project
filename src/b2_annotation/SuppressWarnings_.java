package b2_annotation;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class SuppressWarnings_ {
    //当我们不想看到警告时,可以使用@SuppressWarnings({""})注解来关闭
    //常用all,其他警告类型自己查,太多了
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
       List list=new ArrayList();
       list.add("jack");
       list.add("tom");

    }
}
