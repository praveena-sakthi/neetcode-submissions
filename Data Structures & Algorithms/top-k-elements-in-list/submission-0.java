class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        int len = nums.length;
        Map<Integer,Set<Integer>> bucket = new HashMap<>();
        for(int num : nums) {
            int count = countMap.getOrDefault(num,0);
            if(!bucket.containsKey(count)) {
                bucket.put(count, new HashSet<>());
            }
            if(count > 0) {
                bucket.get(count-1).remove(num);
            }
            bucket.get(count).add(num);
            countMap.put(num,count+1);
        }
        int res [] =new int[k];
        int idx = 0;
        for(int i=len-1;i>=0;i--) {
            if(idx >= k){
                break;
            }
            if(bucket.containsKey(i)) {
                for(int val : bucket.get(i)) {
                    res[idx++] = val;
                }
            }
        }
        return res;

    }
}
