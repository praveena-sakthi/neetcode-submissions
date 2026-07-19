class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, resLen = Integer.MAX_VALUE;
        int resStart = 0, resEnd = 0, reqCount = 0;
        String resStr = "";
        if(s.length() < t.length()) {
            return "";
        }
        int [] freqMap = new int[256];
        for(char c : t.toCharArray()) {
            freqMap[c]++;
            if(freqMap[c]==1) {
                reqCount++;
            }
        }
        int formedCount = 0;
        int [] strFreqMap = new int[256];
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(freqMap[ch]>0) {
                strFreqMap[ch]++;
                if(freqMap[ch] == strFreqMap[ch]) {
                    formedCount++;
                }
            }
            while(formedCount == reqCount) {
                int currLen = right-left+1;
                if(currLen <= resLen) {
                    resLen = currLen;
                    // resStr = s.substring(left,right+1);
                    resStart = left;
                    resEnd = right+1;
                    // System.out.println("Result Str : "+resStr);
                }
                // System.out.println("Before "+strFreqMap);
                char leftChar = s.charAt(left);
                if(freqMap[leftChar]>0){
                    strFreqMap[leftChar]--;
                    if(strFreqMap[leftChar] < freqMap[leftChar]) {
                        formedCount--;
                    }
                }
                // System.out.println("AFter "+strFreqMap);
                left++;
            }
            right++;
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(resStart,resEnd);
    }

    private boolean isAllCharactersFound(Map<Character,Integer> strMap, Map<Character,Integer> patternMap) {
        for(Character c : patternMap.keySet()) {
            if(!strMap.containsKey(c) || strMap.get(c)<patternMap.get(c)) {
                return false;
            }
        }
        return true;
    }
}
