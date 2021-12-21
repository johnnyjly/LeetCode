package Arrays;

public class ValidAnagram_242_Better {
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
        if(s.length() != t.length()) {
            return false;
        }
        //Compared to the previous one, this one is faster as it doesn't use an extra int i to search for
        //the character in the Strings at the corresponding index i. Instead, we loop by characters directly.
        for(char charS: s.toCharArray()){
            array[charS] ++;
        }
        for(char charT: t.toCharArray()){
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
