package selfPractice.binaryTree.bottomView;

import selfPractice.binaryTree.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

public class Solution {
    record Pair<TreeNode, Integer>(TreeNode node, Integer hd) {}
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<Pair<TreeNode, Integer>> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.addFirst(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> pair = q.pollLast();
            map.put(pair.hd(), pair.node().val);

            if (pair.node().left != null) {
                q.addFirst(new Pair(pair.node().left, pair.hd() - 1));
            }
            if (pair.node().right != null) {
                q.addFirst(new Pair(pair.node().right, pair.hd() + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}