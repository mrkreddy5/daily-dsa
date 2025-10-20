public class Count_Good_Numbers {
    public static void main(String[] args) {
        long n = 20;
        System.out.println(good_numbers(n));
    }

    public static int good_numbers(long n){
        long evenBase = 5;
        long oddBase = 4;

        long res = 1;
        long mod = 1000000007;

        long evenCount = (n+1)/2;
        long oddCount = n/2;

        while (evenCount>0 || oddCount>0) {
            if (evenCount % 2 != 0) {
                res = (res * evenBase) % mod;
                n = n - 1;
            } else {
                evenBase = (evenBase * evenBase) % mod;
                n = n / 2; 
            }

            if (oddCount % 2 != 0) {
                res = (res * oddBase) % mod;
                n = n - 1;
            } else {
                oddBase = (oddBase * oddBase) % mod;
                n = n / 2; 
            }
        }

        return (int)(res % mod);
    }
}


/* A good number is a number where every even index (0-based) is a even number and every odd index is prime number
    Here the logic for XPowOfN is applied twice as from 0 to 9 , evens are 0,2,4,6,8 total 5 and primes are 2,3,5,7, total 4
   In n digits of a number(0-indexed) even places are n/2 +1 and odd are n/2
   which means 5 pow (n/2 +1) for evens and 4 pow (n/2) for odds 
   t.c = O(logn)
*/
