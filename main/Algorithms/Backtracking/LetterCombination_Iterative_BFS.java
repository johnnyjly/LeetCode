package Backtracking;

import java.util.*;

public class LetterCombination_Iterative_BFS {
    public static List<String> letterCombinations(String digits){
        LinkedList<String> result = new LinkedList<>();
        if(digits.isEmpty()) return result;
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add(""); // Make the first element of the result not a null object.
        for(int i = 0; i < digits.length(); i++){
            int num = digits.charAt(i) - '0';
            while(result.peek().length() == i){
                String temp = result.remove();
                for(char s: mapping[num].toCharArray()){
                    result.add(temp + s);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("7"));
    }
}
