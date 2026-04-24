
// 	•	Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Output:  zigzag order traversal will be 1 3 2 7 6 5 4.

package inClass.week5.zigzagTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

import inClass.week5.TreeNode;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();

        if (root != null)
            q.offer(root);

        int level = 0;

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

            if (level % 2 == 1) {
                Collections.reverse(res);
            }

            result.add(res);

            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = new TreeNode().generateTree(arr);

        List<List<Integer>> result = solution.zigzagLevelOrder(root);
        System.out.println(result);
    }
}
