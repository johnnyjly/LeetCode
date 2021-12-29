package TwoPointers.kSums;

import java.util.*;

public class FourSum_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){

            /*
             We cannot return result directly as we did in three sums. That's because
             here the target is unknown and if it is an negative number, then even if
             num[i] is greater than the target, it is still possible to be one of the result.
             e.g. target = -11, nums[i] = -5, -5 > -11, but (-5) + (-4) + (-2) + 0 = -11.
            */
            //if(nums[i] > target) return result;

            //Skip the number at this index i if it is the same as the previous number
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < nums.length - 2; j++){
                //Skip the number at this index j if it is the same as the previous number
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while(left <  right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(right > left && nums[left] == nums[left + 1]) left ++;
                        while(right > left && nums[right] == nums[right - 1]) right --;
                        left ++;
                        right --;
                    }else if(sum > target){
                        right --;
                    }else{
                        left ++;
                    }

                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }
}
