public class BestTimeToSellStocks {
    public int maxProfit(int[] prices) {
        int minPrice =prices[0];
        int max=0;
        int newVal=0;
        for(int i=1;i<prices.length;i++)
        {
           if(prices[i]<minPrice) minPrice = prices[i];
           else{
            newVal = prices[i]-minPrice;
            max = Math.max(max, newVal);
           }
        }
        return max;
    }

    /*
       If we can be buy multiple stocks and can get multiple profits , but a single stock at a time
    */

    public int maxProfit1(int[] prices) {
        int profit=0;
        for(int p=1;p<prices.length;p++){
            if(prices[p]>prices[p-1]){
                profit += prices[p]-prices[p-1];
            }
        }
        return profit;
    }

}
