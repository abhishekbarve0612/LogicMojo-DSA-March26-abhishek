package selfPractice.binaryTree.levelOrderTraversal;

import selfPractice.binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.addFirst(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) queue.addFirst(node.left);
                if (node.right != null) queue.addFirst(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
