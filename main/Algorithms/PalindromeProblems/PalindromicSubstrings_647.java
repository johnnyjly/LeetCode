package PalindromeProblems;

public class PalindromicSubstrings_647 {
    /**
     * Given a string s, return the number of palindromic substrings in it.
     * A string is a palindrome when it reads the same backward as forward.
     * A substring is a contiguous sequence of characters within the string.
     *
     * @param s String
     * @return the longest palindromic substring in s.
     */
    public int countSubstrings(String s) {
        int count = 0;
        if(s == null || s.length() == 0){
            return count;
        }
        for(int i = 0; i < s.length(); i++){
            count += isPalindrome(s, i, i);
            count += isPalindrome(s, i, i + 1);
        }
        return count;
    }

    private int isPalindrome(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count ++;
            left --;
            right ++;
        }
        return count;
    }
}
