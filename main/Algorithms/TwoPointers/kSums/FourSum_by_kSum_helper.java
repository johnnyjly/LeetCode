package TwoPointers.kSums;

import java.util.*;

public class FourSum_by_kSum_helper {

    /*
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]]
    such that:
    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target
    You may return the answer in any order.
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    /**
     * This is a helper method that calculates k sum questions.
     * @param nums the array of integers
     * @param target the target of the sum
     * @param k the number of integers in the array that add up to the target
     * @param start the start index of the array nums.
     * @return *the kSum result
     */
    private static List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        int length = nums.length;
        List<List<Integer>> tempResult = new ArrayList<>();
        if(k == 2){
            int left = start;
            int right = length - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == target){
                    /* Important: here we need to transform it into an ArrayList, LinkedList or etc.

                        Arrays.asList returns a fixed-sized list and we cannot add new elements to it.
                        To fix that, we need to use other Lists.
                     */
                    tempResult.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                    //tempResult.add(Arrays.asList(nums[left], nums[right])); This is not suitable in this program.
                    while(left < right && nums[left] == nums[left + 1]) left ++;
                    while(left < right && nums[right] == nums[right - 1]) right --;
                    left ++;
                    right --;
                }else if(sum > target){
                    right --;
                }else{
                    left ++;
                }
            }
        }else{
            for(int i = start; i < length - (k - 1); i++) {
                if(i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);
                for(List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                tempResult.addAll(temp);
            }
        }
        return tempResult;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }
}
