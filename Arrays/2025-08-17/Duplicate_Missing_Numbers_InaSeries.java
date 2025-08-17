
public class Duplicate_Missing_Numbers_InaSeries {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,5,6};
        missingDuplicate(nums);
    }

    public static void missingDuplicate(int[] nums){
        int totXOR = 0;
        for(int i=0;i<nums.length;i++){
            totXOR ^= (i+1)^nums[i];
        }
        
        int setBit = totXOR & (-totXOR);    // gives the rightmost set bit (1) it may be 1,2,4,8,....
        System.out.println(setBit);         // setbit will be helpful to separate array into 2 groups 

        int xor1 = 0;
        int xor2 = 0;

        for(int i=1;i<=nums.length;i++){
            if ((i & setBit)!=0){
                xor1 ^=i;
            }
            else{
                xor2 ^=i;
            }
        }

        for(int i=0;i<nums.length;i++){
            if ((nums[i] & setBit)!=0){
                xor1 ^=nums[i];
            }
            else{
                xor2 ^=nums[i];
            }
        }

        int duplicate =0, missing =0;
        for(int n: nums){
            if(n==xor1){
                duplicate = xor1;
                missing = xor2;
                break;
            }
            if(n==xor2){
                duplicate = xor2;
                missing = xor1;
                break;
            }
        }

        System.out.println("Missing: " + missing + ", " + "Duplicate: " + duplicate);
    }
}


/* T.C = O(n) and S.C = O(1) efficient compared to using n-sized array for frequency or using hashmap
   Instead of final for loop where liner search occurs we can use sum of n numbers and find out the difference between result numbers and find
   out which is duplicate and which one is missing
 */