package d1_algorithm.recursion;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Recursion_Main {//递归算法笔记

    public static void main(String[] args) {
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
        FindWay find = new FindWay();
        find.findWay(map, 1, 1);//i，j是初始坐标
        System.out.println("\n====找路后地图===");
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

class FindWay {
    //0可走 1墙 2走过的路 3为走过但是走不通的死路
    public boolean findWay(int[][] map, int i, int j) {//小鼠走迷宫
        if (map[6][5] == 2) {//如果走到出口
            return true;
        } else {//如果没走到出口
            if (map[i][j] == 0) {//原地是0
                map[i][j] = 2;//原地走过
                if (findWay(map, i + 1, j)) {//下  如果找到了
                    return true;
                } else if (findWay(map, i, j + 1)) {//右
                    return true;
                } else if (findWay(map, i - 1, j)) {//上
                    return true;
                } else if (findWay(map, i, j - 1)) {//左
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
}

//反转字符
class ReverseString {
    public void f(int n, String str) {
        if (n == str.length()) {
            return;
        }
        f(n + 1, str);
        System.out.print(str.charAt(n));
    }

}

//插入排序
class ReverseInsertSort {
    public void f(int[] arr, int low) {
        if (low == arr.length) {
            return;
        }
        int t = arr[low];
        int i = low - 1;
        while (i >= 0 && t < arr[i]) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = t;
        f(arr, low + 1);
    }
}

class HanoiTower {

    LinkedList<Integer> a = new LinkedList<>();
    LinkedList<Integer> b = new LinkedList<>();
    LinkedList<Integer> c = new LinkedList<>();

    public void init(int n) {
        for (int i = n; i > 0; i--) {
            a.add(i);
        }
    }

    public void move(int n, LinkedList<Integer> source,
                            LinkedList<Integer> auxiliary,
                            LinkedList<Integer> target) {
        if (n == 0) {
            return;
        }
        move(n - 1, source, target, auxiliary); // 先将上面n-1个盘子从源柱子移动到辅助柱子
        target.addLast(source.removeLast()); // 移动最大的盘子从源柱子到目标柱子
        System.out.println("移动盘子" + n + "从" + getSourceName(source) + "到" + getSourceName(target));
        printTowers();
        move(n - 1, auxiliary, source, target); // 最后将n-1个盘子从辅助柱子移动到目标柱子
    }

    private String getSourceName(LinkedList<Integer> stack) {
        if (stack == a) return "A";
        if (stack == b) return "B";
        if (stack == c) return "C";
        return "Unknown";
    }

    private void printTowers() {
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c + '\n');
    }

    // 测试方法
    @Test
    public void test() {
        init(3);
        move(3, a, b, c);
    }
}






