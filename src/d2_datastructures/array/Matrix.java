package d2_datastructures.array;

public class Matrix {
    public static void main(String[] args) {
        int [][]A={{1,2},
                   {3,4}};
        int [][]B={{-4,-2}};
        printMat(sumMat(A,B));
        printMat(mulMat(A,B));
    }
    public static void printMat(int [][]M){
        if(M==null){
            return;
        }
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                System.out.print(M[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int[][] sumMat(int [][]A,int[][]B){
        if(A.length!=B.length||A[0].length!=B[0].length){
            System.out.println("矩阵无法相加");
            return null;
        }
        int [][]C=new int[A.length][A[0].length];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                C[i][j]=A[i][j]+B[i][j];
            }
        }
        return C;
    }
    public static int[][] mulMat(int [][]A,int [][]B){
        int M = A.length;
        int N = A[0].length;
        int Q = B.length;
        int P = B[0].length;
        if(N!=Q){
            System.out.println("矩阵无法相乘");
            return null;
        }
        int [][]C=new int [M][P];
        for(int i=0;i<M;i++){
            for (int j=0;j<P;j++){
                for(int k=0;k<N;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        return C;

    }
}
