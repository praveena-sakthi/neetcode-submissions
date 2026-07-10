class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int diff = target-nums[i];
            if(countMap.containsKey(diff)) {
                return new int[]{countMap.get(diff),i};
            }else {
                countMap.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
