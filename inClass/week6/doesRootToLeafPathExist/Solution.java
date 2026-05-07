/**
	•	Given a binary tree and an array, the task is to find if the given array sequence is present as a root-to-leaf path in given tree.


Input : arr[] = {5, 2, 4, 8} for above tree
Output: "Path Exist"
Input :  arr[] = {5, 3, 4, 9} for above tree
Output: "Path does not Exist"

*/

package inClass.week6.doesRootToLeafPathExist;

import inClass.week5.TreeNode;

public class Solution {
    public boolean doesRootToLeafPathExist(TreeNode root, int[] arr) {
        return doesPathExist(root, arr, 0);
    }

    public boolean doesPathExist(TreeNode root, int[] arr, int index) {
        if (index > arr.length - 1) {
            return root == null;
        }

        if (root == null)
            return false;

        if (root.val != arr[index])
            return false;

        // If we have reached the last node of the array
        if (index == arr.length - 1) {
            return root.left == null && root.right == null;
        }

        return doesPathExist(root.left, arr, index + 1)
                || doesPathExist(root.right, arr, index + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = new int[] { 5, 2, 4, 6, 8 };
        int[] arr2 = new int[] { 5, 1, 3 };

        TreeNode root = new TreeNode().generateTree(new int[] { 5, 2, 1, 4, 6, 8, 3 });

        System.out.println(solution.doesRootToLeafPathExist(root, arr1));
        System.out.println(solution.doesRootToLeafPathExist(root, arr2));
    }
}
