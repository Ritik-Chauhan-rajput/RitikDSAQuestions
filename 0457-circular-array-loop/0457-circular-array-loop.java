import java.util.*;

class Solution {

    public int calcNextIdx(int[] nums, int curr) {
        int next = curr;
        int seq = nums[curr];

        if (seq > 0) {
            next = (curr + seq) % nums.length;
        } else {
            int mod = seq % nums.length;
            int forward = nums.length + mod;
            next = (curr + forward) % nums.length;
        }

        return next;
    }

    public boolean circularArrayLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            Set<Integer> set = new HashSet<>();
            set.add(i);

            // nums[1] nahi, nums[i]
            boolean isPos = nums[i] > 0;

            int curr = i;

            while (true) {

                int next = calcNextIdx(nums, curr);

                if (isPos) {

                    if (nums[next] < 0) {
                        break;
                    } else {

                        // contain -> contains
                        if (set.contains(next)) {

                            // Single element loop allow nahi hai
                            if (curr != next) {
                                return true;
                            } else {
                                break;
                            }
                        }

                        set.add(next);
                    }

                } else {

                    if (nums[next] > 0) {
                        break;
                    } else {

                        if (set.contains(next)) {

                            if (curr != next) {
                                return true;
                            } else {
                                break;
                            }
                        }

                        set.add(next);
                    }
                }

                curr = next;
            }
        }

        return false;
    }
}