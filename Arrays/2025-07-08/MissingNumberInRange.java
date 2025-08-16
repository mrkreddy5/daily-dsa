class MissingNumberInRange {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};
        int tot =0;
        for(int n: arr){
            tot+= n;
        }

        int n = arr.length;
        int res = (n*(n+1))/2 - tot;
       
        System.out.println(res);

        
    }
}



/* T.c = O(n) , s.c = O(1)  xor approach is better for handling large numbers where as sum approach
    for simple approach
*/

// public int missingNumber(int[] nums) {
//         int xor1=0;
//         for(int i=1;i<=nums.length;i++){
//             xor1 ^= i;
//         }

//         int xor2 =0;
//         for(int n: nums){
//             xor2 ^= n;
//         }

//         return xor1^xor2;
// }


// public int missingNumber(int[] nums) {
//         int xor=0;
//         for(int i=0;i<nums.length;i++){
//             xor ^= i^nums[i];
//         }

//         xor ^= nums.length;

//         return xor;
// }