class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int stone : stones) {
            count[stone % 3]++;
        }

        int count0 = count[0];
        int count1 = count[1];
        int count2 = count[2];
        if (count0 % 2 == 0) {
            return count1 > 0 && count2 > 0;
        }
        return Math.abs(count1 - count2) > 2;
    }
}