public class MaxConsecutive1s {
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,1,1,0,0,1,1};
        int h =0;
        int c =0;
        for(int n: arr){
            if(n==1){
                c++;
            }
            else{
                c=0;
            }
            h = Math.max(h,c);
        }

        System.out.println(h);
    }
}

// t.c = O(n) , s.c = O(1)