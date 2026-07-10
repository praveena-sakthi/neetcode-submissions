class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        Set<Integer> distinctElems = new HashSet<>();
        for(int num : set) {
            if(!set.contains(num-1)) {
                distinctElems.add(num);
            }
        }
        int max = 0;
        for(int elem : distinctElems) {
            int count = 0;
            int val = elem;
            while(set.contains(val)) {
                count++;
                val++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
