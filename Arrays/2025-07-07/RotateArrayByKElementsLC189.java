package Arrays;

public class RotateArrayByKElementsLC189 {
    public void rotate(int[] nums, int k) 
    {
        if(k>nums.length) k =k % nums.length; 
        reverse(nums,0,nums.length-1); 
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public void reverse(int[] nums, int i,int k)
    {
        while(i<k)
        {
            int temp= nums[i];
            nums[i]=nums[k];
            nums[k]=temp;
            i++;
            k--;
        }
    }
}


// t.c = O(n + k + (n-k))= O(n)
// s.c = O(1)