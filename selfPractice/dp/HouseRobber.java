package selfPractice.dp;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        return solveMemo(nums);
    }


    // ===================== 1. MEMOIZATION (Top-Down) =====================
    int[] memo;

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 7, 9, 3, 1 };
        // expected ans: 12
        HouseRobber cn = new HouseRobber();
        System.out.println(cn.solveMemo(arr));
    }
    public int solveMemo(int[] arr) {
        int n = arr.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
//        return dp(arr, n - 1);
//        return solveTab(arr);
        return solveSpaceOptimized(arr);
    }

    private int dp(int[] arr, int i) {
        if (i < 0) return 0;
        if (i == 0) return arr[0];
        if (i == 1) return Math.max(arr[0], arr[1]);
        if (memo[i] != -1) return memo[i];

        int option1 = arr[i] + dp(arr, i - 2);
        int option2 = dp(arr, i - 1);

        memo[i] = Math.max(option1, option2);            // or max / sum
        return memo[i];
    }

    // ===================== 2. TABULATION (Bottom-Up) =====================
    public int solveTab(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        if (n < 1) return 0;
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int option1 = dp[i - 1];
            int option2 = arr[i] + dp[i - 2];
            dp[i] = Math.max(option1, option2);
        }
        return dp[n - 1];
    }

    // ================= 3. SPACE OPTIMIZATION (O(1) space) =================
    public int solveSpaceOptimized(int[] arr) {
        int n = arr.length;
        int prev2 = arr[0];
        int prev1 = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            int option1 = prev1;
            int option2 = arr[i] + prev2;
            int curr = Math.max(option1, option2);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
/*
198. House Robber
Solved
Medium
Topics
conpanies icon
Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */