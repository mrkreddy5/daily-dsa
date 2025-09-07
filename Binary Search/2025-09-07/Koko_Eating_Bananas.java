public class Koko_Eating_Bananas {
    public static void main(String[] args) {
        int[] piles = {312884470};
        int h = 312884469;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
       
        int low = 1;
        int high = maxNum(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalHours = 0;
            for (int p : piles) {
                totalHours += (p + mid - 1) / mid;
            }
            if (totalHours <= h) {
                high = mid - 1;  
            } else {
                low = mid + 1;   
            }
        }
        return low;
    }
    
    public static int maxNum(int[] piles){
        int max = piles[0];
        for(int n: piles){
            if(n>max) max =n;
        }
        return max;
    }
}


// T.C = O(nlogm) => O(logm) for binary search O(n) for hour calculation s.c = O(1)
