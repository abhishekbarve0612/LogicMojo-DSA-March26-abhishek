/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 5000]
-200 <= Node.val <= 200
*/
package selfPractice.hashing.findDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import inClass.week5.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Solution {
    HashMap<String, List<TreeNode>> hash;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hash = new HashMap<>();
        res = new ArrayList<>();
        dfs(root);

        return res;
    }

    public String dfs(TreeNode node) {
        if (node == null)
            return "null";
        String s = "(" + dfs(node.left) + "," + node.val + "," + dfs(node.right) + ")";
        if (hash.containsKey(s) && hash.get(s).size() == 1)
            res.add(node);
        if (hash.containsKey(s))
            hash.get(s).add(node);
        else
            hash.put(s, new ArrayList<>(List.of(node)));
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { 1, 2, 3, 4, -1, 2, 4, -1, -1, -1, -1, 4, -1 };
        TreeNode root = new TreeNode().generateTree(arr);
        List<TreeNode> res = s.findDuplicateSubtrees(root);
        for (TreeNode node : res) {
            System.out.println(node.val);
        }
    }
}
