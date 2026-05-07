package inClass.week6.areTwoTreesMirror;

import inClass.week5.TreeNode;

public class Solution {
    public boolean areTwoTreesMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return areTwoTreesMirror(root1.left, root2.right) && areTwoTreesMirror(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[] { 1, 2, 2, 3, 4, 4, 3 };
        int[] arr2 = new int[] { 1, 2, 2, 3, 4, 4, 3 };

        TreeNode root1 = new TreeNode().generateTree(arr1);
        TreeNode root2 = new TreeNode().generateTree(arr2);

        System.out.println(solution.areTwoTreesMirror(root1, root2));
    }
}
