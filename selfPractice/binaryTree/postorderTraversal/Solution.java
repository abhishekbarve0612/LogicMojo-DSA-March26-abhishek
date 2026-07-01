package selfPractice.binaryTree.postorderTraversal;

import selfPractice.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    List<Integer> result;

    public List<Integer> postorderTraversal(TreeNode root) {
//        result = new ArrayList<>();
//        recurse(root);
//        return result;
        return iterate(root);
    }

    public void recurse(TreeNode root) {
        if (root == null) return;
        recurse(root.left);
        recurse(root.right);
        result.add(root.val);
    }

    public List<Integer> iterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stk1 = new ArrayDeque<>();
        Deque<TreeNode> stk2 = new ArrayDeque<>();

        stk1.add(root);

        while (!stk1.isEmpty() || !stk1.isEmpty()) {
            TreeNode node = stk1.pollLast();
            while (node != null) {
                stk2.add(node);
                node = node.right;
            }
            node = stk2.pollLast();


        }
        return result;
    }
}
