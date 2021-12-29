package HashMap;

import java.util.HashMap;

public class FourSum_II_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        //Get the lenght of the arrays
        int length = nums1.length;

        //Initialize the hashmap and the count (i.e. output)
        HashMap<Integer, Integer> mapping = new HashMap<>();
        int count = 0;

        /*
        Get the sum of the two arrays and put them into the mapping with Key equals the sum, and Value equals the number
         of occurrences.
        */
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if (!mapping.containsKey(sum)) {
                    mapping.put(sum, 1);
                } else {
                    int tempCount = mapping.get(sum);
                    mapping.put(sum, tempCount + 1);
                }
                /*
                Instead of the above if-else, we could replace by the following codes:
                -> mapping.compute(sum, (k, v) -> (v == null) ? 1 : v + 1);

                Here, compute method allows us to update the value of the corresponding key in the map.
                 */
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = -(i + j);
                if (mapping.containsKey(sum)){
                    count += mapping.get(sum);
                }
                /*
                Similarly,
                -> count += mapping.getOrDefault(sum, 0);

                Here, getOrDefault method allows us to get the value of the corresponding key in the map.
                If no such key, then return the default value (i.e. 0 in this case).
                 */
            }
        }
        return count;
    }
}
