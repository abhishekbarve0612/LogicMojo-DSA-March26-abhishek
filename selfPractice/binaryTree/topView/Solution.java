package selfPractice.binaryTree.topView;

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
    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<Pair<TreeNode, Integer>> q = new LinkedList<>();

        Map<Integer, Integer> map = new TreeMap<>();

        if (root != null) q.addFirst(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> top = q.pollLast();
            map.putIfAbsent(top.hd(), top.node().val);

            if (top.node().left != null) {
                q.addFirst(new Pair(top.node().left, top.hd() - 1));
            }
            if (top.node().right != null) {
                q.addFirst(new Pair(top.node().right, top.hd() + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}