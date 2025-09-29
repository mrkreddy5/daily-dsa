
public class Book_Allocation {
    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int m = 2;
        System.out.println(minimized_maximum(nums,m));
    }

    public static int minimized_maximum(int[] nums, int m){
        if(m>nums.length) return -1;
        else{
            int[] min_max = min_max(nums);
            if(m==nums.length) return min_max[0];

            int low = min_max[0];
            int high = min_max[1];
            int ans = high;
            System.out.println(low + ":" + high);
            while(low<=high){
                int mid = low + (high-low)/2;
                
                if(canAllocate(nums, mid, m)){
                    ans = mid;
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            // System.out.println(ans);
            return ans;
        }
    }

    public static boolean canAllocate(int[] nums, int mid , int m){
        int currP =0;
        int studC =1;
        for(int p : nums){
            if(p>mid){
                return false;
            }
            if(currP + p <= mid){
                currP += p;
            }
            else{
                currP = p;
                studC++;
                if(studC >m) return false;
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


/*
    According to problem student every student atleast get 1 book , we have to allocate books where the student gets highest pages is minimum
    from example : 25, 46, 28, 49, 24 , m =4
    definitely a student should get 2 books 
    25 + 46 = 71
    46 + 28 = 74
    28 + 49 = 77
    49 + 24 = 73
    among all this 71 is the minimum among max 
    so answer will always lie between max(arr) and sum(arr)

    T.C = O(nlog(sum(arr)))
 */
