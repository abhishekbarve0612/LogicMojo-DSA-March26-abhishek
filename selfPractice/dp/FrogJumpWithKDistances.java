package selfPractice.dp;

import java.util.Arrays;

public class FrogJumpWithKDistances {

    public int frogJump(int[] heights, int k) {
        return solveMemo(heights, k);
    }

    // ===================== 1. MEMOIZATION (Top-Down) =====================
    int[] memo;

    public static void main(String[] args) {
        int[] heights = new int[] { 10, 5, 20, 0, 15 };
        int k = 2;
        // expected ans: 15
        FrogJumpWithKDistances f = new FrogJumpWithKDistances();
        System.out.println(f.solveMemo(heights, k));
    }

    public int solveMemo(int[] arr, int k) {
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return solveTab(arr, k, n - 1);
    }

    private int dp(int[] arr, int k, int i) {
        if (i < 1) return 0;
        if (i == 1) return Math.abs(arr[1] - arr[0]);
        if (memo[i] != -1) return memo[i];

        int option = Integer.MAX_VALUE;
        for (int jump = Math.max(0, i - k); jump < i; jump++) {
            option = Math.min(
                    Math.abs(arr[i] - arr[jump]) + dp(arr, k, jump),
                    option
            );
        }

        memo[i] = option;
        return memo[i];
    }

    // ===================== 2. TABULATION (Bottom-Up) =====================
    public int solveTab(int[] arr, int k, int target) {
        int n = arr.length;
        if (target < 1) return 0;
        if (target >= n) return Integer.MAX_VALUE;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(arr[0] - arr[1]);


        for (int i = 2; i <= target; i++) {
            int option = Integer.MAX_VALUE;

            for (int jump = Math.max(0, i - k); jump < i; jump++) {
                option = Math.min(
                        option,
                        Math.abs(arr[i] - arr[jump]) + dp[jump]
                );
            }
            dp[i] = option;
        }
        return dp[target];
    }

    // ================= 3. SPACE OPTIMIZATION (O(1) space) =================


    public int solveSpaceOptimized(int[] arr, int k, int target) {
        int n = arr.length;
        if (target < 1) return 0;
        if (target >= n) return Integer.MAX_VALUE;
        int[] dp = new int[k + 1];
        dp[0] = 0;
        dp[1] = Math.abs(arr[0] - arr[1]);

        for (int i = 1; i <= target; i++) {
            int option = Integer.MAX_VALUE;
            for (int jump = Math.max(0, i - k); jump < i; jump++) {
                option = Math.min(
                        option,
                        Math.abs(arr[i] - arr[jump]) + dp[jump % k]
                );
            }
            dp[i % k] = option;
        }
        return dp[target % k];
    }
}

/*
Frog jump with K distances
Medium

Hints
Company
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k.



To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists.



Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.


Example 1

Input: heights = [10, 5, 20, 0, 15], k = 2

Output: 15

Explanation:

0th step -> 2nd step, cost = abs(10 - 20) = 10

2nd step -> 4th step, cost = abs(20 - 15) = 5

Total cost = 10 + 5 = 15.

Example 2

Input: heights = [15, 4, 1, 14, 15], k = 3

Output: 2

Explanation:

0th step -> 3rd step, cost = abs(15 - 14) = 1

3rd step -> 4th step, cost = abs(14 - 15) = 1

Total cost = 1 + 1 = 2.
 */