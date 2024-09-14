package algorithm;

import java.util.Scanner;

public class Recursion {//递归算法笔记

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("请选择你要查看的斐波那契额数列项数:");
        int n = scan.nextInt();
        System.out.println("斐波那契额数列的第" + n + "项是" + rAlg.Fib(n));


        System.out.print("请选择你要计算的桃子剩余量的天数:");
        int day = scan.nextInt();
        System.out.println("第" + day + "天有" + rAlg.peach(day) + "个桃子");


        int[][] map = new int[8][7];
        int i, j;
        for (i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        System.out.println("====当前地图===");
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        rAlg find = new rAlg();
        find.FindWay(map, 1, 1);//i，j是初始坐标
        System.out.println("\n====找路后地图===");
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

//
//        char a = 'a', b = 'b', c = 'c';
//        System.out.println("请输入盘子的数量:");
//        int num = scan.nextInt();
//        rAlg HanLuoTower = new rAlg();
//        System.out.println("移动盘子的具体操作如下");
//        HanLuoTower.move(num, a, b, c);
//        System.out.println("需要移动的次数为" + HanLuoTower.move_count(num) + "次");
    }
}

class rAlg {
    public static long Fib(int n) {//斐波那契额数列
        return (n > 0 && n <= 2) ? 1 : (Fib(n - 1) + Fib(n - 2));
    }


    public static long peach(int day) {//猴子每天吃一半价一个桃子，10天后剩余1个
        return day == 10 ? 1 : (peach(day + 1) + 1) * 2;
    }


    //0可走 1墙 2走过的路 3为走过但是走不通的死路
    public boolean FindWay(int[][] map, int i, int j) {//小鼠走迷宫
        if (map[6][5] == 2) {//如果走到出口
            return true;
        } else {//如果没走到出口
            if (map[i][j] == 0) {//原地是0
                map[i][j] = 2;//原地走过
                if (FindWay(map, i + 1, j)) {//下  如果找到了
                    return true;
                } else if (FindWay(map, i, j + 1)) {//右
                    return true;
                } else if (FindWay(map, i - 1, j)) {//上
                    return true;
                } else if (FindWay(map, i, j - 1)) {//左
                    return true;
                } else {//如果上下左右都没找到
                    map[i][j] = 3;
                    return false;
                }
            } else {//如果原地是1,2,3
                return false;
            }
        }
    }

    public void move(int num, char a, char b, char c) {//移动汉罗塔过程
        if (num == 1) {
            System.out.println(a + "->" + c);
        } else {
            move(num - 1, a, c, b);
            System.out.println(a + "->" + c);
            move(num - 1, b, a, c);

        }
    }

    public long move_count(int n) {//移动汉罗塔次数
        return n == 1 ? 1 : move_count(n - 1) * 2 + 1;
    }
}

