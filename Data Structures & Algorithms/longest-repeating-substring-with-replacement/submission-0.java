class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxFreq = 0, result = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(right = 0;right<s.length();right++) {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            while((right-left+1)-maxFreq > k) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left))-1);
                left++;
            }
            result = Math.max(right-left+1, result);
        }
        return result;
    }
}
