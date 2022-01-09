package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations_77_better{

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backTracking(result, path, n, k, 1);
        return result;
    }

    private void backTracking(List<List<Integer>> result, LinkedList<Integer> path, int n, int k, int startIndex) {
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            backTracking(result, path, n, k, i + 1);
            path.removeLast();
        }
    }

}
