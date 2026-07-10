class Solution {
    private boolean isAlphaNumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        s=s.toLowerCase();
        while(left<right) {
            if(!isAlphaNumeric(s.charAt(left))){
                left++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(right))){
                right--;
                continue;
            }
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
