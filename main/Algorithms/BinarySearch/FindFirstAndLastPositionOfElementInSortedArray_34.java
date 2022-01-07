package BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                while(left <= right && nums[left] != target) left ++;
                while(left <= right && nums[right] != target) right --;
                return new int[] {left, right};
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
