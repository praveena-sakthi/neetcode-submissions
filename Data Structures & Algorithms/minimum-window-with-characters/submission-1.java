class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, resLen = s.length();
        String resStr = "";
        if(s.length() < t.length()) {
            return "";
        }
        Map<Character,Integer> freqMap = new HashMap<>();
        for(char c : t.toCharArray()) {
            int count = freqMap.getOrDefault(c,0);
            freqMap.put(c,count+1);
        }
        Map<Character,Integer> strFreqMap = new HashMap<>();
        while(right < s.length()) {
            char ch = s.charAt(right);
            if(freqMap.containsKey(ch)) {
                int count = strFreqMap.getOrDefault(ch,0);
                strFreqMap.put(ch,count+1);
            }
            while(left <= right && isAllCharactersFound(strFreqMap,freqMap)) {
                int currLen = right-left+1;
                if(currLen <= resLen) {
                    resLen = currLen;
                    resStr = s.substring(left,right+1);
                    // System.out.println("Result Str : "+resStr);
                }
                // System.out.println("Before "+strFreqMap);
                char leftChar = s.charAt(left);
                if(freqMap.containsKey(leftChar)){
                    strFreqMap.put(leftChar, strFreqMap.get(leftChar)-1);
                }
                // System.out.println("AFter "+strFreqMap);
                left++;
            }
            right++;
        }
        return resStr;
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
