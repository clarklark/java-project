package d1_algorithm.divedeConquer;

public class quickPow {
    public static void main(String[] args) {
        System.out.println(pow(5,15));
    }
    //快速幂a^15=a^8*a^4*a^2*a^1
    public static long pow(long a,long n){
        if(n==0){
            return 1;
        }
        long res = a;//记录a
        long ex=1;
        while((ex<<1)<=n){//终止条件即找到 2^4 > 15,循环3次
            res*=res;//((a^2)^2)^2 = a^8
            ex<<=1;//ex = 8
        }
        return res*pow(a,n-ex);//a^15 = (a^8)*a^(15-8)
                                 //      = (a^8)*(a^4)*a^(7-4)
                                 //      = (a^8)*(a^4)*(a^2)*a^(3-2)
                                 //      = (a^8)*(a^4)*(a^2)*(a^1)
    }
}


