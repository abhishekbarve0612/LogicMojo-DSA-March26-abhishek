package selfPractice.binaryTree.inOrderTraversal;

import selfPractice.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        // result = new ArrayList<>();
        // recurse(root);
        // return result;
        return iterate(root);
    }

    public void recurse(TreeNode root) {
        if (root == null) return;
        recurse(root.left);
        result.add(root.val);
        recurse(root.right);
    }

    public List<Integer> iterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stk = new ArrayDeque<>();

        TreeNode curr = root;
        while (curr != null || !stk.isEmpty()) {
            while (curr != null) {
                stk.add(curr);
                curr = curr.left;
            }
            curr = stk.pollLast();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }

}
