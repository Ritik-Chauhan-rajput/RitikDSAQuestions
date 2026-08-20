class Solution {

    public int totalFruit(int[] fruits) {
        int[] freq = new int[fruits.length + 1];
        int left = 0;
        int count = 0;
        int max = 0;
        for(int right = 0; right < fruits.length; right++) {
            if(freq[fruits[right]] == 0) {
                count++;
            }
            freq[fruits[right]]++;
            while(count > 2) {
                freq[fruits[left]]--;
                if(freq[fruits[left]] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}