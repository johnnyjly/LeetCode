

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder tempString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            CharSequence c = s.subSequence(i,i+1);
            if(tempString.toString().contains(c)){
                if(tempString.length() > maxLength){
                    maxLength = tempString.length();
                }
                tempString = new StringBuilder(tempString.substring(tempString.indexOf((String) c) + 1));
            }
            tempString.append((String) c);
        }
        return Math.max(maxLength, tempString.length());
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
    }
}
