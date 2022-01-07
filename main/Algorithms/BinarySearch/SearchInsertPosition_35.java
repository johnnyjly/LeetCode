package BinarySearch;

public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]){
            return 0;
        }else if(target > nums[nums.length - 1]){
            return nums.length;
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
        return left;
    }
}
