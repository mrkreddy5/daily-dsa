public class XPowOfN {
    public static void main(String[] args) {
        double x = 2.0000;
        int n= 9;
        boolean status = true;
        if(n<0){
            status = false;
            n = -1*n;
        }
        double res = 1;
        res = usingRecursion(x, n, res);
        System.out.println(status == false ? 1 / res : res);
    }

    public static double bruteForce(double x, int n){
        double res = 1;
        if(n>0){
            for(int i=1;i<=n;i++){
                res = res * x;
            }
        }
        else{
            for(int i=1;i<=n;i++){
                res = res / x;
            }
        }
        return res;
    }

    /* Brute force : Multiplying the x , n times , for -n we can make it in several ways t.c = O(n) , which is very large for large inputs
       
        In optimised version we did the same thing like in brute force , but here incrementing the X where as by reducing the power n to the half 
        if it is perfectly divided as multiple of 2 , if it is not we will make it to the multiple of 2 by reducing it and making approproiate
        calculation of result (adding x to res), until x is a multiple of 2 x will be doubled and n will be reduced to half

        x =2           n = 11
        x =2 , res =2  n = 10 
        x =4 , res =2  n = 5
        x =4 , res =8  n = 4
        x =16, res =8  n = 2
        x =256, res =8 n = 1
        x =256, res = 256*8, n=0
        
        
        for -ve (n) we calculate the same res and return 1/res
        
        t.c = O(logn)
        s.c = O(1)
     */


    public static double optimisedVers(double x, int n){
        double res = 1;
        long exp = n < 0 ? -(long)n : n; 

        while (exp > 0) {
            if (exp % 2 != 0) {  
                res = res * x;
                exp = exp - 1;
            } else {
                x = x * x;
                exp = exp / 2;
            }
        }

        if (n < 0) return 1 / res;
        return res;
    }


    /* Using recursion we get the same result with same t.c = O(logn) but s.c = O(logn) */

    public static double usingRecursion(double x, int n, double res){
        System.out.println(x + " : " + n + " : " + res);
        if(n==0){
            return res;
        }
        else{
            if(n%2!=0){
                return usingRecursion(x, n-1, res * x);
            }
            else{
                return usingRecursion(x*x, n/2 , res);
            }
        }
    }
}
