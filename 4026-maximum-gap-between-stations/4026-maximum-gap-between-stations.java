class Solution {
    public int maximumGap(String skill, String station) {

        int n = skill.length();
        int m = station.length();

        int[] left = new int[n];
        int[] right = new int[n];

        int p = 0;

        for (int i = 0; i < n; i++) {

            while (station.charAt(p) != skill.charAt(i)) {
                p++;
            }

            left[i] = p;
            p++;
        }

        p = m - 1;

        for (int i = n - 1; i >= 0; i--) {

            while (station.charAt(p) != skill.charAt(i)) {
                p--;
            }

            right[i] = p;
            p--;
        }

        int answer = 0;

        for (int i = 1; i < n; i++) {

            int gap = right[i] - left[i - 1];

            answer = Math.max(answer, gap);
        }

        return answer;
    }
}