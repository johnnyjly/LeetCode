package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCombination_Backtracking_DFS {

    LinkedList<String> result = new LinkedList<>();
    String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits){
        if(digits.isEmpty()) return result;

        StringBuilder track = new StringBuilder();
        backTrack(digits, track, 0); // We need a index since the letter sets for each layers are different.
        return result;
    }

    private void backTrack(String digits, StringBuilder track, int index) {
        if(track.length() == digits.length()){
            result.add(track.toString()); // Track length == digits length == layers length
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++){
            track.append(letters.charAt(i)); // Add one letter in this layer
            backTrack(digits, track, index + 1); // Move on to the next layer
            track.deleteCharAt(track.length() - 1); // Return to the last layer by removing the letter in the current layer
        }
    }
}
