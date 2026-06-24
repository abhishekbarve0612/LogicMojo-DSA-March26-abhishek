/*
Given a Binary Tree, return the diagonal traversal of the binary tree.

Consider lines of slope -1 passing between nodes. Given a Binary Tree, return a single list containing all diagonal elements in a binary tree belonging to same line.
If the diagonal element are present in two different subtrees then left subtree diagonal element should be taken first and then right subtree. 

Examples :

Input : root = [8, 3, 10, 1, 6, N, 14, N, N, 4, 7, 13]

Output : [8, 10, 14, 3, 6, 7, 13, 1, 4]
Explanation:

Diagonal Traversal of binary tree : 8 10 14 3 6 7 13 1 4
Input: root = [1, 2, N, 3, N]

Output: [1, 2, 3]
Constraints:
1 <= number of nodes<= 105
1 <= node->data <= 105
 */

package inClass.week6BinaryTree.diagonalTraversalOfBinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import inClass.week5.TreeNode;

public class Solution {

    record NodeInfo(TreeNode node, int level) {
    }

    public ArrayList<ArrayList<Integer>> diagonalTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<NodeInfo> q = new ArrayDeque<>();

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        int level = 0;

        q.offer(new NodeInfo(root, level));

        while (!q.isEmpty()) {
            NodeInfo nodeInfo = q.poll();
            TreeNode node = nodeInfo.node();
            int currLevel = nodeInfo.level();
            map.putIfAbsent(currLevel, new ArrayList<>());
            map.get(currLevel).add(node.val);

            if (node.left != null) {
                q.offer(new NodeInfo(node.left, currLevel + 1));
            }

            if (node.right != null) {
                q.offer(new NodeInfo(node.right, currLevel));
            }
        }

        for (ArrayList<Integer> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 3, 10, 1, 6, -1, 14, -1, -1, 4, 7, 13, -1, -1, -1 };
        TreeNode node = new TreeNode();
        TreeNode root = node.generateTree(arr);
        node.printPreOrder(root);

        Solution solution = new Solution();

        ArrayList<ArrayList<Integer>> ans = solution.diagonalTraversal(root);
        System.out.println(ans);
    }
}
