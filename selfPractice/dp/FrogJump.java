package selfPractice.dp;

import java.util.Arrays;

public class FrogJump {

    public int frogJump(int[] heights) {
        return solveMemo(heights);
    }

        // ===================== 1. MEMOIZATION (Top-Down) =====================
        int[] memo;

        public int solveMemo(int[] arr) {
            int n = arr.length;
            memo = new int[n];
            Arrays.fill(memo, -1);
//            return dp(arr, n - 1);
            return solveSpaceOptimized(arr);
        }

        private int dp(int[] arr, int i) {

            if (i == 0) return 0;
            if (i == 1) return Math.abs(arr[0] - arr[1]);
            if (memo[i] != -1) return memo[i];

            int option1 = Math.abs(arr[i] - arr[i - 1]) + dp(arr, i - 1);
            int option2 = Math.abs(arr[i] - arr[i - 2]) + dp(arr, i - 2);

            memo[i] = Math.min(option1, option2);
            return memo[i];
        }

        // ===================== 2. TABULATION (Bottom-Up) =====================


        public int solveTab(int[] arr) {
            int n = arr.length;
            if (n < 2) return 0;
            int[] dp = new int[n];
            dp[0] = 0;
            dp[1] = Math.abs(arr[0] - arr[1]);

            for (int i = 2; i < n; i++) {
                int option1 = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
                int option2 = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
                dp[i] = Math.min(option1, option2);
            }
            return dp[n - 1];
        }
        // ================= 3. SPACE OPTIMIZATION (O(1) space) =================
        public int solveSpaceOptimized(int[] arr) {
            int n = arr.length;
            if (n < 2) return 0;
            int prev2 = 0;
            int prev1 = Math.abs(arr[0] - arr[1]);

            for (int i = 2; i < n; i++) {
                int option1 = prev1 + Math.abs(arr[i] - arr[i - 1]);
                int option2 = prev2 + Math.abs(arr[i] - arr[i - 2]);
                int curr = Math.min(option1, option2);

                prev2 = prev1;
                prev1 = curr;
            }
            return prev1;
        }
}

/*
Frog Jump
Medium

Hints
Company
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step.



To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from any step either one or two steps, provided it exists.



Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.


Example 1

Input: heights = [2, 1, 3, 5, 4]

Output: 2

Explanation:

One possible route can be,

0th step -> 2nd Step = abs(2 - 3) = 1

2nd step -> 4th step = abs(3 - 4) = 1

Total = 1 + 1 = 2.

Example 2

Input: heights = [7, 5, 1, 2, 6]

Output: 9

Explanation:

One possible route can be,

0th step -> 1st Step = abs(7 - 5) = 2

1st step -> 3rd step = abs(5 - 2) = 3

3rd step -> 4th step = abs(2 - 6) = 4

Total = 2 + 3 + 4 = 9.
 */