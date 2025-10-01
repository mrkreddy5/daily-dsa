public class Painters_Partition {
    public static void main(String[] args) {
        int A=3, B=2;
        int[] C={5, 10, 30, 20};
        System.out.println(min_time(A,B,C));
    }

    public static int min_time(int A, int B, int[] C){
        int[] low_high = min_max(C);
        if(A>C.length){
            return (low_high[0]*B) % 10000003;
        }
        else{
            int low = low_high[0];
            int high = low_high[1];
            int res = high;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(valid_res(A, C, mid)){
                    res = mid;
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            return (res*B)% 10000003;
        }
    }

    public static boolean valid_res(int A,int[] C, int mid){
        int p=1;
        int c_units = 0;
        for(int c : C){
            if(c>mid) return false;
            else if((c_units + c) <=mid){
                c_units += c;
            }
            else{
                p++;
                c_units = c;
                if(p>A) return false;
            }
        }
        return true;
    }

    public static int[] min_max(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int n : nums){
            if(n>max) max = n;
            sum +=n;
        }
        return new int[]{max,sum};
    }
}
