package a1_tool;
//常用快捷键
/*
1.ctrl+/       注释
2.ctrl+alt+↓   复制当前行
3.alt+/        补全代码
4.alt+enter    自动倒入该行需要的类
5.ctrl+alt+l   代码格式化
6.shift+F10    快捷运行
7.alt+insert   快捷生成构造器
8.ctrl+H       查看类的层级关系
9.Ctrl+B       选择定位到哪个类的方法
10.+.var       自动分配变量
11.ctrl+alt+t  快捷生成简单模板
*/

public class Tool{
    public static  void main(String []args){

        //牛顿迭代法求平方根
        double number=2;
        double e=1e-15;
        double t=number;
        while (Math.abs(t - number / t) > e * t) {
            t = (number / t + t) / 2.0;
        }
        System.out.println(t);
    }
}

