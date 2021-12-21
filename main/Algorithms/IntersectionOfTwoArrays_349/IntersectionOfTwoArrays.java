package IntersectionOfTwoArrays_349;

import java.util.*;

public class IntersectionOfTwoArrays {
    /**
     * Given two integer arrays nums1 and nums2, return an array of their intersection.
     * Each element in the result must be unique and you may return the result in any order.
     *
     * @param nums1 integer array
     * @param nums2 integer array
     * @return an array of their intersection
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set contains no duplicate elements. So we use set and therefore, hashSet.
        Set<Integer> sNums1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for(int num: nums1){
            sNums1.add(num);
        }
        for(int num: nums2){
            if(sNums1.contains(num)){
                resultSet.add(num);
                sNums1.remove(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for(int num: resultSet){
            result[i] = num;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
