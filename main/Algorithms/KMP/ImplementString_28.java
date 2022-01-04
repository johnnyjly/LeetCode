package KMP;

import java.util.Arrays;

public class ImplementString_28 {
    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for(int i = 0; i < haystack.length(); i++){
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            if(j == needle.length() - 1){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    private static void getNext(int[] next, String needle) {
        int j = -1;
        next[0] = j;
        for(int i = 1; i < needle.length(); i++){
            while(j >= 0 && needle.charAt(i) != needle.charAt(j + 1)){
                j = next[j];
            }
            if(needle.charAt(i) == needle.charAt(j + 1)){
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        String s = "aabaaf";
        int[] next = new int[s.length()];
        getNext(next, s);
        System.out.println(Arrays.toString(next));
    }
}
