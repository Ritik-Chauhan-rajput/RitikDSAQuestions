class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefix = 0;
        int count = 0;
        int[] freq = new int[k];
        freq[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int rem = prefix % k;

            if (rem < 0) {
                rem += k;
            }
            count += freq[rem];
            freq[rem]++;
        }
        return count;
    }
}