package selfPractice.binaryTree.preorderTraversal;

import selfPractice.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        // result = new ArrayList<>();
        // recurse(root);
        // return result;
        return iterate(root);
    }

    public void recurse(TreeNode root) {
        if (root == null) return;
        result.add(root.val);
        recurse(root.left);
        recurse(root.right);
    }

    public List<Integer> iterate(TreeNode root) {
        Deque<TreeNode> stk = new ArrayDeque<>();

        if (root != null) stk.add(root);
        List<Integer> result = new ArrayList<>();

        while (!stk.isEmpty()) {
            TreeNode node = stk.pollLast();

            result.add(node.val);
            if (node.right != null) stk.add(node.right);
            if (node.left != null) stk.add(node.left);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = new TreeNode(preorder[0]);
        root.generateTree(preorder);
        Solution solution = new Solution();
        List<Integer> result = solution.preorderTraversal(root);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}