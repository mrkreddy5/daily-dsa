
public class Reverse_Pairs {
    public static void main(String[] args) {
        int[] nums = {25,3,18,11,6,7};
        System.out.println(mergeSort(nums,0, nums.length));
    }
    public static int mergeSort(int[] nums, int low, int high){
        int k =0;
        if(low<high){
            int mid = low + (high-low)/2;
            k+=mergeSort(nums,low,mid);
            k+=mergeSort(nums,mid+1,high);
            k+=merge(nums,low,mid,high);
        }
        return k;
    }

    public static int merge(int[] nums, int low, int mid, int high){
        int[] sorted = new int[high-low+1];
        int k=0;
        int y=mid+1;
        int pairs = 0;
        int i =low,j= mid+1;
        for(int x=low;x<=mid;x++){
            while(y<=high && nums[x]>2*nums[y]){
                y++;
            }
            pairs += y - (mid+1);
        }
        
        while(i<=mid && j<=high){
            if(nums[i]<nums[j]){
                sorted[k++]= nums[i++];
            }
            else{
                sorted[k++]= nums[j++];  
            }
        }
        while(i<=mid){
            sorted[k++]= nums[i++];
        }
        while(j<=high){
            sorted[k++]= nums[j++];
        }

        for(int x=0;x<sorted.length;x++){
            nums[low+x]= sorted[x];
        }

        return pairs;
    }
}


/* this takes O(n*logn) 
   Generally T.C = O(n*logn) => O(logn) for splitting and (n) for merging

   s.c = O(n)


   the sorted part of low to mid and mid+1 to high comes for merging
   where we find the pairs for example , [12,17,28] , [5,8,13] came for merging
   we start at 12(low) and traverse through the array completely
   when nums[i]=12 , nums[j]=5  nums[i]>2*nums[j] so j++ = 4, then 
               nums[j]=8  fails , so add till then to pairs i.e elements before j to after mid = j-mid-1 (as j incremented , means current j should be counted)

    
    if [12,17,28] , [2,3,5] came as 2 sorted arrays
    then nums[i]=12 , nums[j]=2 , condition satisfied and j++
                    nums[j]=3 again satisfied j++
                    nums[j]= 5 again j++ => 6

    so for i(iteration) pairs += j-(mid+1) =>6-3 =3 so total 9 pairs will be added
 */