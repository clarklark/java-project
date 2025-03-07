package d2_datastructures.array;

public class Homework {
    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4, 17},
                {5, 6, 7, 8, 18},
                {9, 10, 11, 12, 19},
                {13, 14, 15, 16, 20},
                {21, 22, 23, 24, 25}};
        int[][] b = {
                { 1, 2, 3, 4, 5, 6, 7, 8},
                { 9,10,11,12,13,14,15,16},
                {17,18,19,20,21,22,23,24},
                {25,26,27,28,29,30,31,32}};
        int []c={-2,1,-3,4,-1,2,1,-5,4};
        cirPrint(a);
        snakePrint(b);
        System.out.println(subMax(c));

    }

    //环形打印
    public static void cirPrint(int[][] arr) {
        int c = 0;
        int r = 0;
        int end = arr[0].length - 1;
        int start = 0;
        System.out.print(arr[0][0] + " ");
        while (start <= end) {
            while (r < end) {
                System.out.print(arr[c][++r] + " ");
            }
            r = end;
            while (c < end) {
                System.out.print(arr[++c][r] + " ");
            }

            while (r > start) {
                System.out.print(arr[c][--r] + " ");
            }
            while (c > start + 1) {
                System.out.print(arr[--c][r] + " ");
            }
            start++;
            end--;
        }
        System.out.println();
    }

    //蛇形打印
    public static void snakePrint(int[][] arr) {
        int x = 0;
        int y = 0;
        while (x < arr.length && y < arr[0].length) {
            // 右上走
            while (x >= 0 && y < arr[0].length) {
                System.out.print(arr[x--][y++] + " ");
            }
            //两种出界情况
             if (y == arr[0].length) {
                y = arr[0].length - 1;
                x += 2;
            }else if (x == -1) {
                x = 0;
            }
            //左下走
            while (x < arr.length && y >= 0) {
                System.out.print(arr[x++][y--] + " ");
            }
            if (x == arr.length) {
                x = arr.length - 1;
                y += 2;
            }else if (y == -1) {
                y = 0;
            }
        }
        System.out.println();
    }
    //求子数组最大和: Kadane 算法
    public static int subMax(int []arr){
        int currentMax=arr[0];
        int globalMax=arr[0];
        for(int i=1;i<arr.length;i++){
            currentMax = Math.max(arr[i],currentMax+arr[i]);
            globalMax = Math.max(currentMax,globalMax);
        }
        return globalMax;
    }

}
