// 	•	Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.
// Input: root = [3,9,20,15,7]
// Output: [3.00000,14.50000,11.00000]

package inClass.week5.averagesOfLevelElements;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import inClass.week5.TreeNode;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();

        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
            result.add(sum / size);

        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 3, 9, 20, -1, -1, 15, 7 };
        TreeNode root = new TreeNode().generateTree(arr);

        List<Double> result = solution.averageOfLevels(root);
        System.out.println(result);
    }
}
