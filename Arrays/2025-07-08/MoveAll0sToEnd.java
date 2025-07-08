public class MoveAll0sToEnd {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,0,1,1};
        int s =0;
        int l = nums.length-1;
        while(s<=l){
            while(nums[s]!=0 && s<=l)  s++;
            while(nums[l]==0 && l>=s)  l--;
            if(s<l){
                nums[s++]=1;
                nums[l--]=0;
            }
        }
    }
}


/*  t.c = O(n) , s.c = O(1) for both but above code doesn't preserve like below one


        int[] nums = {0, 1, 1, 0, 0, 1, 1};
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        while (index < nums.length) {
            nums[index++] = 0;
        }
 
 */
