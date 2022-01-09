package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> lst = new LinkedList<>();
        backTrack(n, lst, k); // We need a index since the letter sets for each layers are different.
        return result;
    }

    private void backTrack(int n, LinkedList<Integer> lst, int k) {
        if(lst.size() == k){
            result.add(new ArrayList<>(lst));
            return;
        }
        for(int i = n; i >= 1; i--){
            lst.add(i);
            backTrack(i - 1, lst, k);
            lst.remove(lst.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations_77 c = new Combinations_77();
        System.out.println(c.combine(4,4));
    }

}
