class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int left = 0, right = 0;
        int freq [] = new int[26];
        if(s1.length()>s2.length())
        return false;
        for(char c : s1.toCharArray()) {
            freq[c-'a']++;
        }
        while(right < left+s1.length()) {
            freq[s2.charAt(right)-'a']--;
            right++;
        }
        while(left < s2.length()-s1.length()) {
            // System.out.println(left+" : "+Arrays.toString(freq));
            if(isAllCharFound(freq)) {
                return true;
            }else {
                freq[s2.charAt(left)-'a']++;
                left++;
                
                freq[s2.charAt(right)-'a']--;
                right++;
            }
        }
        return isAllCharFound(freq);
    }

    private boolean isAllCharFound(int [] freq) {
        for(int i=0;i<26;i++) {
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}
