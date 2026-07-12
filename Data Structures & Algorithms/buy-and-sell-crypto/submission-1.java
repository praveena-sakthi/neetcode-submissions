class Solution {
    public int maxProfit(int[] prices) {
        int idx = 1;
        int maxProfit = 0;
        int minVal  = prices[0];
        int len = prices.length;
        int min[] = new int[len];
        for(int i=0;i<len;i++) {
            minVal = Math.min(minVal,prices[i]);
            min[i]=minVal;
        }
        int maxSoFar = 0;
        for(int i=len-1;i>=0;i--) {
            maxSoFar = Math.max(maxSoFar,prices[i]);
            maxProfit = Math.max(maxSoFar-min[i], maxProfit);
        }
        return maxProfit;
    }
}
