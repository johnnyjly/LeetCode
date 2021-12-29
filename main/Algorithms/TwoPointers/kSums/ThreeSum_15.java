package TwoPointers.kSums;

import java.util.*;

public class ThreeSum_15 {

    /**
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     *
     * Notice that the solution set must not contain duplicate triplets.
     *
     * @param nums an Integer array
     * @return all the non-duplicate triplets
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // If the length of the given array is less than 3, then no 3 sums.
        if(nums.length < 3){
            return result;
        }
        //Sort the array in ascending order.
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 1; i++){
            // Since the list is already sorted in ascending order, if nums[i] is greater than 0, then it's done.
            if(nums[i] > 0){
                return result;
            }
            //Skip the number at this index i if it is the same as the previous number
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // Initialize the left/right pointer, which both point to the numbers that are greater than nums[i]
            int left = i + 1;
            int right = nums.length - 1;
            //Figure out all the possible combinations of left and right at this i
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Jump all the duplicate right/left numbers
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                // If sum > 0, the right may be too big
                }else if(sum > 0){
                    right --;
                // If sum < 0, the left may be too small
                }else{
                    left ++;
                }
            }

        }
        return result;

    }
}
