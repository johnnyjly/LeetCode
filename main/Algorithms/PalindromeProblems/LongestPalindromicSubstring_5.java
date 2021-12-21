package PalindromeProblems;


public class LongestPalindromicSubstring_5 {
    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * @param s String
     * @return the longest palindromic substring in s.
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = isLongest(s, i, i);
            int len2 = isLongest(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     *  Check and return the length of the longest palindrome of this center.
     *
     * @param s the original string
     * @param left the initial center of the string
     * @param right the initial center of the string (equal to left if this is a string of odd length)
     * @return return the length of the longest palindrome of this center.
     */
    private static int isLongest(String s, int left, int right) {
        int l = left, r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l --;
            r ++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
