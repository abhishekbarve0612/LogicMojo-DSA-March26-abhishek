/*

Given the root of a binary tree, return the sum of values of its deepest leaves.



Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

 */

package inClass.week6.deepestLevelSum;

import inClass.week5.TreeNode;

public class Solution {
    private int total = 0;
    private int maxLevel = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;

        if (level > maxLevel) {
            total = root.val;
            maxLevel = level;
        } else if (level == maxLevel) {
            total += root.val;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode().generateTree(new int[] { 1, 2, 3, 4, 5, -1, 6, 7, -1, -1, -1, -1, 8 });

        System.out.println(s.deepestLeavesSum(root) == 15);
    }

}
