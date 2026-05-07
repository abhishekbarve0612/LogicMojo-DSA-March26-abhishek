/**
 * Given a binary tree, where every node value is a Digit from 1-9. Find the sum of all the numbers which are formed from root to leaf paths. 



Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

 */

package inClass.week6.sumOfRootToLeafNumbers;

import inClass.week5.TreeNode;

public class Solution {

    private int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return totalSum;
    }

    public void helper(TreeNode root, int val) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            totalSum += val * 10 + root.val;
            return;
        }
        helper(root.left, val * 10 + root.val);
        helper(root.right, val * 10 + root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode().generateTree(new int[] { 4, 9, 0, 5, 1 });

        System.out.println(s.sumNumbers(root) == 1026);

        Solution s2 = new Solution();

        TreeNode root2 = new TreeNode().generateTree(new int[] { 1, 2, 3 });

        System.out.println(s2.sumNumbers(root2) == 25);
    }
}
