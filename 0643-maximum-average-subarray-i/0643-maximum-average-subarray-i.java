class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
        long maxSum=sum;
        for(int j=k;j<nums.length;j++){
            sum=sum-nums[j-k];
            sum=sum+nums[j];
            maxSum=Math.max(maxSum,sum);
        }
        return (double) maxSum/k;
    }
}