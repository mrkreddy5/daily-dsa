public class NextPermutation {
    public void nextPermutation(int[] nums){
        int minInd = -1;
        int n = nums.length-1;
        for(int i=n-1;i>=0;i--){
            if(nums[i]<nums[i+1]){
                minInd = i;
            }
        }

        int maxInd = -1;
        for(int i=n-1;i>minInd;i--){
            if(nums[i]>nums[minInd]){
                maxInd = i;
            }
        }

        swap(nums,minInd,maxInd);

        int m = minInd+1;
        int l = n-1;
        while(minInd+1<n){
            swap(nums,m,l);
            m++;
            l--;
        }
    }

    public void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
