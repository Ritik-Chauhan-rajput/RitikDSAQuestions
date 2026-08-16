class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {

        int k = requests.length;
        int totalMasks = 1 << k;

        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[totalMasks][k];

        for (int mask = 0; mask < totalMasks; mask++) {
            for (int i = 0; i < k; i++) {
                dp[mask][i] = INF;
            }
        }

        for (int i = 0; i < k; i++) {

            int arrival = requests[i][0];
            int floor = requests[i][1];

            long travel = Math.abs(start - floor);

            long time = Math.max(travel, (long) arrival);

            dp[1 << i][i] = time;
        }

        for (int mask = 1; mask < totalMasks; mask++) {

            for (int i = 0; i < k; i++) {

                if ((mask & (1 << i)) == 0) {
                    continue;
                }

                if (dp[mask][i] == INF) {
                    continue;
                }

                int currentFloor = requests[i][1];
                long currentTime = dp[mask][i];

                for (int j = 0; j < k; j++) {

                    if ((mask & (1 << j)) != 0) {
                        continue;
                    }

                    int nextFloor = requests[j][1];
                    int arrival = requests[j][0];

                    long travel =
                        Math.abs(currentFloor - nextFloor);

                    long reachTime =
                        currentTime + travel;

                    long newTime =
                        Math.max(reachTime, (long) arrival);

                    int newMask = mask | (1 << j);

                    dp[newMask][j] =
                        Math.min(dp[newMask][j], newTime);
                }
            }
        }

        int fullMask = totalMasks - 1;

        long answer = INF;

        for (int i = 0; i < k; i++) {
            answer = Math.min(answer, dp[fullMask][i]);
        }

        return answer;
    }
}