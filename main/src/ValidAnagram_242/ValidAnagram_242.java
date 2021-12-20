package ValidAnagram_242;

import java.util.*;

public class ValidAnagram_242 {
    /**
     *
     * @param s consists of lowercase English letters.
     * @param t consists of lowercase English letters.
     * @return true if t is an anagram of s, and false otherwise.
     *
     * 1 <= s.length, t.length <= 5 * 104
     *
     */
    public static boolean isAnagram(String s, String t) {
        int[] array = new int[128];
        if(s.length() != t.length()){
            return false;
        }else if(s.length() == 0 && t.length() == 0){
            return true;
        }
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            array[charS] ++;
            array[charT] --;
        }
        for(int j: array){
            if(j != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abcb", "bba"));
    }
}
