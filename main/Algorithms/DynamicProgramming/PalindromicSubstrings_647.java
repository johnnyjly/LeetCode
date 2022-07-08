package DynamicProgramming;

import java.util.HashMap;

public class PalindromicSubstrings_647 {
    public int countSubstrings(String s) {
        int ans = 0;
        int len = s.length();
        // Initialize a Dynamic Programming table
        boolean[][] dp = new boolean[len][len];

        // Start from i = len - 1, j = i; where i is the left pointer, j is the right pointer.
        // Reason is that when we get s.charAt(i) = s.charAt(j), and if we know that dp[i+1][j-1] is a palindrome,
        // we know that s.substring(i, j+1) is a palindrome. So O(1).
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // if i,j the same or adjacent indices, they're palindrome
                    if (i == j || i == j - 1) {
                        ans += 1;
                        dp[i][j] = true;
                    } else {
                        // else, it depends on the substring within, i.e., s.substring(i+1, j).
                        if (dp[i+1][j-1]) {
                            ans += 1;
                        }
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
        return ans;
    }
}
