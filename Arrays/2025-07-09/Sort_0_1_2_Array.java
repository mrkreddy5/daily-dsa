public class Sort_0_1_2_Array {

    public void sort(int[] nums){
        int l = 0;
        int m = 0;
        int h = nums.length-1;
        while(m<=h){
            if(nums[m]==0){
                swap(nums,l,m);
                l++;
                m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else{
                swap(nums,m,h);
                h--;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }
}



/* the above problem uses Dutch National Flag process to sort the numbers
    where it works like array is divided into 4 parts
    0 to low-1 ==> 0's are sorted here
    low to mid-1 ==> 1's are sorted here
    mid to high ==> contains 0,1,2's all are unsorted ----> this is the part which has to be sorted
    high+1 to n-1 ===> 2's are sorted

    if mid element is 0 ,swap it with 0's area and move, low and mid pointer
    if it is 1 , no need of any swaps just move front i.e mid pointer
    if it is 2 , swap it with high which is the last position of unsorted part , after swap make high as 2's sorted part i.e high--



    t.c = O(n) , s.c = O
 */