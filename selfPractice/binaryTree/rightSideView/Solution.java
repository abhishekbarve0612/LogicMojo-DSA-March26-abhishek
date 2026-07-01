package selfPractice.binaryTree.rightSideView;

import selfPractice.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.addFirst(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.pollLast();
                if (i == size - 1) result.add(node.val);

                if (node.left != null) q.addFirst(node.left);
                if (node.right != null) q.addFirst(node.right);
            }
        }
        return result;
    }
}
