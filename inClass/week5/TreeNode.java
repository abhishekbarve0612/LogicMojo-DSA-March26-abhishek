package inClass.week5;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode generateTree(int[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        for (int i = 1; i < arr.length; i += 2) {
            TreeNode node = q.poll();

            if (arr[i] != -1) {
                node.left = new TreeNode(arr[i]);
                q.offer(node.left);
            }

            if (arr[i + 1] != -1) {
                node.right = new TreeNode(arr[i + 1]);
                q.offer(node.right);
            }
        }

        return root;
    }
}