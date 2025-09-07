
public class mth_Root_of_N {
    public static void main(String[] args) {
        int n = 625;
        int m =4;
        int ans =-1;
        int low =1;
        int high = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            double p = Math.pow(mid,m);
            if(p==n){
                ans = mid;
                break;
            }
            else if(p<n){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        System.out.println(ans);
    }
}
