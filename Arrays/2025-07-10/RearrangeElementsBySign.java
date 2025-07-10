public class RearrangeElementsBySign {

    public void rearrangeElements(int[] nums){
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        int negInd = 0 , posInd =0;

        for(int num : nums){
            if(num>=0) pos[posInd++]= num;
            if(num<0) neg[negInd++]= num;
        }

        for(int i=0;i<=n/2;i++){
            nums[2*i] = pos[i];
            nums[2*i+1] = neg[i];
        }
    }


    /*
        Both codes uses extra space O(n), but when we compare t.c , it is O(n)+ O(n) = O(2n) for above code
        where as O(n) for below code
    */

    public void rearrangeElements1(int[] nums){
        int n = nums.length;
        int[] res = new int[nums.length];
        int posInd = 0;
        int negInd = 1;
        for(int num : nums){
            if(num<0 && posInd<n){
                res[posInd]= num;
                posInd+=2;
            }
            if(num>=0 && negInd<n){
                res[negInd]= num;
                negInd+=2;
            }
        }

        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

}
