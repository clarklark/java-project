package d1_algorithm.math;

import java.util.Scanner;

public class NimGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int []arr= new int[N];
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
        }
        nimGame(arr);
    }
    //nim问题,N个堆,各有若干个小石头,拿走最后一个石头的人获胜
    public static void nimGame(int []arr){
        int sum=0;
        for (int i : arr) {
            sum ^= i;
        }
        if(sum==0){
            System.out.println("后手必胜");
        }else{
            System.out.println("先手必胜");
        }

    }


}
