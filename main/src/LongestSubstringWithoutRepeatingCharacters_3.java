import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            maxLength = Math.max(j - i + 1, maxLength);
            map.put(s.charAt(j), j);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abbaas"));
    }
}
