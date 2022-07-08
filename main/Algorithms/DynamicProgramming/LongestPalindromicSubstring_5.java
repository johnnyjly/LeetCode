package DynamicProgramming;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int start = 0, end = 0; // To store the start/end of the longest palindrome in s.
        int len = s.length();
        // Initialize a dp table
        boolean[][] dp = new boolean[len][len];
        // Similar to Q647, we need to start from i = len and j = i.
        for (int i = len; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j - i < 2 || dp[i + 1][j - 1];
                    if (dp[i][j] && j - i > end - start) {
                        start = i;
                        end = j;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
