public class MaximumSubArray {
    public void maxSubArray(int[] nums){
        int sum = Integer. MIN_VALUE;
        int cs =0;
        for(int n : nums){
            cs = Math.max(n,cs+n);
            sum = Math.max(cs, sum);
        }
    }
}


/* The above alogorithm is kadane's algorithm 
    The above logic is when neg result may even accepted
    If only positive sum is accepted make cs =0 if it went <0 even on adding the current element
 */