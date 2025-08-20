public class Max_Inversions {
    public static void main(String[] args) {
        int[] nums = {2,8,6,4,5,7};
        // inversions(nums);
        System.out.println(merge(nums, 0, nums.length-1));
    }

    public static void inversions(int[] nums){
        int count =0;
        for(int i=0;i<nums.length-1;i++){
            int curr = nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(curr>nums[j]) count++;
            }
        }
        System.out.println(count);
    }

    public static int merge(int[] nums, int low, int high){
        int count = 0;
        if(low<high){
            int mid = (low+high)/2;
            count += merge(nums,low,mid);
            count += merge(nums,mid+1,high);
            count += mergeSort(nums,low,mid,high);
        }
        return count;
    }

    public static int mergeSort(int[] nums, int low, int mid, int high){
        int[] sortedNums = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        int inversions = 0;
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                sortedNums[k++]= nums[i++];
            }
            else{
                sortedNums[k++] = nums[j++];
                inversions += mid-i+1;              // when nums[i] is big , then from low to mid every one can be a inversion
            }
        }
        while(i<=mid){
            sortedNums[k++]= nums[i++];
        }
        while(j<=high){
            sortedNums[k++]= nums[j++];
        }

        for (int x = 0; x < sortedNums.length; x++) {
            nums[low + x] = sortedNums[x];
        }
        return inversions;
    }
}


/* Inversion i<j and nums[i]>nums[j]
 Time complexity = O(n^2) for brute force using nested for loop , S.C = O(1)
  where as O(nlogn) => for splitting O(logn) for merging O(n) for merge sort methodology and s.c =O(n) 
 */