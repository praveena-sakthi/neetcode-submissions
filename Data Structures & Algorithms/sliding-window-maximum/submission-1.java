class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i,j) -> nums[j]-nums[i]);
        int left = 0, right = 0;
        int [] result = new int[nums.length-k+1];
        int resIdx = 0;
        for(int i=0;i<nums.length;i++) {
            pq.add(i);
            if(pq.size()>k){
                // System.out.println(i+": "+nums[pq.peek()]);
                pq.remove(i-k);
            }
            if(pq.size()==k){
                result[resIdx++] = nums[pq.peek()];
                
            }
        }
        // result[resIdx] = nums[pq.peek()];
        // while(right < k) {
        //     pq.add(right);
        //     right++;
        // }
        // // right++;
        // result[0]=nums[pq.peek()];
        // int resIdx = 1;
        // while(left < nums.length-k) {
        //     pq.add(right);
        //     pq.remove(left);
        //     result[resIdx] = nums[pq.peek()];
        //     left++;
        //     right++;
        // }
        return result;
    }
}
