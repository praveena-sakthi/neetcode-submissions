class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i=0;i<piles.length;i++) {
            max = Math.max(max,piles[i]);
        }
        int left = 1, right = max;
        int res = max;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(canEat(piles,h,mid)) {
                res = Math.min(res,mid);
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return res;
    }

    private boolean canEat(int [] piles, int h, int k) {
        int count = 0;
        for(int i=0;i<piles.length;i++) {
            count += (piles[i]/k);
            if(piles[i]%k > 0){
                count++;
            }
        }
        return count <=h;
    }
}
