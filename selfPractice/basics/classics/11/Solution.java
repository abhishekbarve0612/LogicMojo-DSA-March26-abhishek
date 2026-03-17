// 11. Container With Most Water
// Solved
// Medium
// Topics
// conpanies icon
// Companies
// Hint
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

 

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1
 

// Constraints:

// n == height.length
// 2 <= n <= 105
// 0 <= height[i] <= 104
 
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 5,158,247/8.6M
// Acceptance Rate
// 59.6%
// Topics
// icon
// Companies
// 0 - 3 months
// Google
// 32
// Amazon
// 28
// Microsoft
// 13
// Meta
// 11
// Bloomberg
// 10
// Oracle
// 3
// Apple
// 2
// Goldman Sachs
// 2
// Yandex
// 2
// 0 - 6 months
// TikTok
// 5
// Flipkart
// 3
// Walmart Labs
// 3
// Zoho
// 3
// Capital One
// 3
// tcs
// 2
// Nvidia
// 2
// PayPal
// 2
// Salesforce
// 2
// 6 months ago
// SAP
// 9
// ServiceNow
// 5
// Deloitte
// 4
// Adobe
// 4
// Uber
// 4
// IBM
// 3
// Infosys
// 3
// Wix
// 3
// Visa
// 3
// Myntra

class Solution {
    public int maxArea(int[] height) {
        int maxCapacity = 0;

        int first = 0, last = height.length - 1;

        while (first < last) {
            int currentCapacity = Math.min(height[first], height[last]) * (last - first);
            maxCapacity = Math.max(maxCapacity, currentCapacity);
            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }

        return maxCapacity;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height)); // Output: 49

        int[] height2 = {1,1};
        System.out.println(solution.maxArea(height2)); // Output: 1
    }
}