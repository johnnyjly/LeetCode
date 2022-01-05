package Arrays;

import java.util.Arrays;
public class NextPermutation_31 {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e., sorted in ascending order).
     *
     * The replacement must be in place and use only constant extra memory.
     *
     * @param nums the list of numbers
     */
    public void nextPermutation1(int[] nums) {
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    Arrays.sort(nums, i + 1, nums.length - 1);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    /**
     * Below is the solution given by the Leetcode, which seems to be more time efficient.
     * @param nums the list of numbers
     */
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
