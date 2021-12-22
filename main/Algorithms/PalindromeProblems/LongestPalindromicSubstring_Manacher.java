package PalindromeProblems;

public class LongestPalindromicSubstring_Manacher {
    /**
     * Given a string s, return the longest palindromic substring in s.
     *
     * @param s String
     * @return the longest palindromic substring in s.
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }else if(s.length() < 2){
            return s;
        }
        int center = 0, rightBoundary = 0, maxLength = 0, maxCenter = 0;
        int[] pLength = new int[s.length() * 2 + 1];
        for(int i = 0; i < pLength.length; i++){
            int mirror = center - (i - center);
            if(i < rightBoundary){
                pLength[i] = Math.min(rightBoundary - i, pLength[mirror]);
            }
            while (((i + pLength[i]) + 1 < pLength.length && (i - pLength[i]) > 0) &&
                    (((i + pLength[i] + 1) % 2 == 0) ||
                            (s.charAt((i + pLength[i] + 1) / 2) ==
                                    s.charAt((i - pLength[i] - 1) / 2)))){
                pLength[i] ++;
            }

            if (pLength[i] > maxLength) // Track maxLength
            {
                maxLength = pLength[i];
                maxCenter = i;
            }

            if(pLength[i] + i > rightBoundary){
                center = i;
                rightBoundary = pLength[i] + i;
            }
        }
        int start, end;
        start = (maxCenter - maxLength) / 2;
        end = start + maxLength - 1;
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcbcaa"));
    }
}
