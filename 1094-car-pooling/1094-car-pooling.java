class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] buckets = new int[1001];

        for (int[] trip : trips) {
            int pass = trip[0];
            int start = trip[1];
            int end = trip[2];

            buckets[start] += pass;
            buckets[end] -= pass;
        }

        int passenger = 0;

        for (int bucket : buckets) {
            passenger += bucket;

            if (passenger > capacity) {
                return false;
            }
        }

        return true;
    }
}