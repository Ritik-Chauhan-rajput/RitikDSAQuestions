import java.util.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int dups = 0;
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) == 2) {
               dups++;
            }
           sum += nums[i];
        }
        if (dups == 0) {
           max = Math.max(max, sum);
        }
        for (int i = k; i < nums.length; i++) {
            int numToAdd = nums[i];
            int numToRemove = nums[i - k];
            map.put(numToAdd, map.getOrDefault(numToAdd, 0) + 1);
            if (map.get(numToAdd) == 2) {
                dups++;
            }
            sum += numToAdd;
            if (map.get(numToRemove) == 2) {
                dups--;
            }
            map.put(numToRemove, map.get(numToRemove) - 1);
            if (map.get(numToRemove) == 0) {
                map.remove(numToRemove);
            }
            sum -= numToRemove;
            if (dups == 0) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}