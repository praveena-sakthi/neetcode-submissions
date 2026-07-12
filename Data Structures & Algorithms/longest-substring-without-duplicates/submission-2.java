class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int [] idx = new int[256];
        Arrays.fill(idx,0);
        int maxLength = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int ascii = c;
            // System.out.println(idx[ascii]+" "+c);
            idx[ascii]++;
            while(start < s.length() && hasDuplicates(idx)) {
                // System.out.println("Duplicate found at "+i+" and start : "+start);
                int startChar = s.charAt(start);
                idx[startChar]--;
                start++;
            }
            // idx[ascii] = i;
            // System.out.println(((i-start)+1)+" : "+s.substring(0,i+1));
            maxLength = Math.max(maxLength, (i-start)+1);
        }
        return maxLength;
    }

    private boolean hasDuplicates(int [] idx) {
        for(int i=0;i<idx.length;i++) {
            if(idx[i]>1) {
                return true;
            }
        }
        return false;
    }
}
