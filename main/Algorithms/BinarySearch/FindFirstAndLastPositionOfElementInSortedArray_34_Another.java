package BinarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray_34_Another {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]){
            return new int[] {-1, -1};
        }
        int mid = binarySearch(nums, target);
        if(mid == -1) return new int[] {-1, -1};
        int left = mid, right = mid;
        while(left > 0 && nums[left - 1] == target) left --;
        while(right < nums.length - 1 && nums[right + 1] == target) right ++;
        return new int[] {left, right};
    }
    public int binarySearch(int[] nums, int target) {
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
}
