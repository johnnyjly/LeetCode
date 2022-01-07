package BinarySearch;
import java.util.Arrays;
public class BinarySearch_704 {
    /**
     * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
     * to search target in nums. If target exists, then return its index. Otherwise, return -1.
     *
     * You must write an algorithm with O(log n) runtime complexity.
     * @param nums the array of integers which is sorted in ascending order
     * @param target the integer target
     * @return its index iff it exists. -1 otherwise.
     */
    public static int search(int[] nums, int target) {
        if(target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, -1));
    }
}
