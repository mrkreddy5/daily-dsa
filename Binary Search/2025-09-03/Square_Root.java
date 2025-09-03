import java.util.*;

public class Square_Root {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=1;
        while(i*i < n){
            i++;
        }

        if(n-(i-1)*(i-1)<=i*i-n){
            System.out.println(i-1);
        }
        else{
            System.out.println(i);
        }
    }
}


// t.c = O(sqrt(n)) , s.c =O(1)