package selfPractice.dp;

import java.util.Arrays;

public class MinCostClimbingStairs {

    // ===================== 1. MEMOIZATION (Top-Down) =====================
    int[] memo;

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 5, 20, 0, 15 };
        int k = 2;
        // expected ans: 15
        MinCostClimbingStairs cn = new MinCostClimbingStairs();
        System.out.println(cn.solveMemo(arr));
    }
    public int solveMemo(int[] arr) {
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(arr, n - 1);
    }

    private int dp(int[] arr, int i) {
        if (i == 0) return /* base case value */ 0;      // smallest input
        if (memo[i] != -1) return memo[i];

        int option1 = /* recurse dp(arr, i - 1) + cost */ 0;
        int option2 = /* recurse dp(arr, i - 2) + cost, guard i > 1 */ 0;

        memo[i] = Math.min(option1, option2);            // or max / sum
        return memo[i];
    }

    // ===================== 2. TABULATION (Bottom-Up) =====================
    public int solveTab(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = /* base case value */ 0;

        for (int i = 1; i < n; i++) {
            int option1 = dp[i - 1] /* + cost */;
            int option2 = i > 1 ? dp[i - 2] /* + cost */ : Integer.MAX_VALUE;
            dp[i] = Math.min(option1, option2);
        }
        return dp[n - 1];
    }

    // ================= 3. SPACE OPTIMIZATION (O(1) space) =================
    public int solveSpaceOptimized(int[] arr) {
        int n = arr.length;
        int prev2 = 0;              // dp[i-2]
        int prev1 = /* dp[0] */ 0;  // dp[i-1]

        for (int i = 1; i < n; i++) {
            int option1 = prev1 /* + cost */;
            int option2 = i > 1 ? prev2 /* + cost */ : Integer.MAX_VALUE;
            int curr = Math.min(option1, option2);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
