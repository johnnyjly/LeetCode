package HashMap;

import java.util.*;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        int[] output = new int[2];
        int counter = 0;
        for(int num: nums){
            if(!tempMap.containsKey(num)){
                tempMap.put((target - num), counter);
            }
            else{
                output[0] = tempMap.get(num);
                output[1] = counter;
                return output;
            }
            counter ++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] output = twoSum(nums, target);
        assert output != null;
        assert output[0] == 2;
        assert output[1] == 7;
    }
}

