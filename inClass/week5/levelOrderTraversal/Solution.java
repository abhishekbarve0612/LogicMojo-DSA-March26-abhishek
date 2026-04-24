// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

package inClass.week5.levelOrderTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import inClass.week5.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();

        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                res.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            result.add(res);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 3, 9, 20, 10, -1, 15, 7, -1, -1, 11, -1, 12, 13, -1, -1 };
        TreeNode root = new TreeNode().generateTree(arr);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
