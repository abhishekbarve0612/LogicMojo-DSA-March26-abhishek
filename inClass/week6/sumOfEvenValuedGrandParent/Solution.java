/**
 * Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.
A grandparent of a node is the parent of its parent if it exists.





Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

 */
package inClass.week6.sumOfEvenValuedGrandParent;

import inClass.week5.TreeNode;

public class Solution {
    private int total = 0;

    public int getSumOfEvenValuedGrandParent(TreeNode root) {
        dfs(root, null, null);
        return total;
    }

    public void dfs(TreeNode node, TreeNode parent, TreeNode grandParent) {
        if (node == null)
            return;
        if (grandParent != null) {
            if (grandParent.val % 2 == 0) {
                total += node.val;
            }
        }
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode()
                .generateTree(new int[] { 6, 7, 8, 2, 7, 1, 3, 9, -1, 1, 4, -1, -1, -1, 5 });

        System.out.println(s.getSumOfEvenValuedGrandParent(root) == 18);
    }
}
