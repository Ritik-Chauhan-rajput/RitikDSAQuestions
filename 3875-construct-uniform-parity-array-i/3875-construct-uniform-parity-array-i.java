class Solution {
    public boolean uniformArray(int[] nums1) {
        int even=-1;
        int odd=-1;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i]%2==0){
                even=nums1[i];
            }else{
                odd=nums1[i];
            }
        }
        return true;
    }
}