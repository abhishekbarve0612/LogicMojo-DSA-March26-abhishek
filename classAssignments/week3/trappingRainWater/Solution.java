// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

// Input Format

// First line is the length of the array
// Next line is elements of the array

// Constraints

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

// Output Format

// Return single integer that is how much water stored

// Sample Input 0

// 12
// 0 1 0 2 1 0 1 3 2 1 2 1
// Sample Output 0

// 6
// Sample Input 1

// 3
// 1 10 0
// Sample Output 1

// 0

package classAssignments.week3.trappingRainWater;

import java.util.List;

public class Solution {
    public static int rain_water(List<Integer> heights) {
        int[] leftMax = new int[heights.size()];
        int[] rightMax = new int[heights.size()];
        int totalWater = 0;
        leftMax[0] = heights.get(0);
        rightMax[heights.size() - 1] = heights.get(heights.size() - 1);

        for (int i = 1; i < heights.size(); i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights.get(i));
            int end = heights.size() - i - 1;
            rightMax[end] = Math.max(rightMax[end + 1], heights.get(end));
        }

        for (int i = 1; i < heights.size() - 1; i++) {
            totalWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - heights.get(i));
        }

        return totalWater;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        List<Integer> heights = new java.util.ArrayList<>();

        for (int num : arr)
            heights.add(num);

        int result = rain_water(heights);

        System.out.println(result);
    }
}
