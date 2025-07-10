public class MaximumSubArray {


    public void maxSubArray(int[] nums){
        int sum = Integer. MIN_VALUE;
        int cs =0;
        for(int n : nums){
            cs = Math.max(n,cs+n);
            sum = Math.max(cs, sum);
        }
    }

    /* The above alogorithm is kadane's algorithm 
        The above logic is when neg result may even accepted
        If only positive sum is accepted make cs =0 if it went <0 even on adding the current element
    */

    public void maxSubArray1(int[] nums){
        int sum = Integer. MIN_VALUE;
        int cs =0;
        for(int n : nums){
            cs += n;
            if(cs <0) cs =0;
            sum = Math.max(cs, sum);
        }
    }


    /*
        The below code is to return the start and end indices of max sub array
     */

    public int[] returnMaxSubArray(int[] nums){
        int sum = Integer. MIN_VALUE;
        int cs =0;
        int resStart = 0;
        int resEnd = 0;
        int start =0;
        for(int i=0;i<nums.length;i++){

            cs += nums[i];

            if(cs>sum){
                sum = cs;
                resStart = start;
                resEnd = i;
            }

            if(cs<0){
                start = i+1;
                cs = 0;
            } 
        }

        return new int[]{resStart, resEnd};
        
    }
}


