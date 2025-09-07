
import java.util.*;

public class Square_Root {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int i=1;
        // while(i*i < n){
        //     i++;
        // }

        // if(n-(i-1)*(i-1)<=i*i-n){
        //     System.out.println(i-1);
        // }
        // else{
        //     System.out.println(i);
        // }

// t.c = O(sqrt(n)) , s.c =O(1)

        // int ans = 0;
        // for(int i=1;i<=n;i++){
        //     if(i*i<=n) ans =i;
        //     else break;
        // }

        // System.out.println(ans);

// return floor of sq.root of a number

        int low = 1;
        int high = n;
        int ans = 0;
        while (low <= high) {
            int m = low + (high - low) / 2;
            if (m * m <= n) {
                ans = m;       // update with current valid candidate
                low = m + 1;   // search right half for potentially larger answer
            } else {
                high = m - 1;  // search left half
            }
        }
        System.out.println(ans); // floor square root


        // O(logn) is better than O(sqrt(n)) in algorithm analysis
    }
}


