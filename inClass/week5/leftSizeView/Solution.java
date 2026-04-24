// 	•	Print the left view of a tree.
// Input: root = [3,9,20,15,7]
// Output : [3, 9, 15]

package inClass.week5.leftSizeView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import inClass.week5.TreeNode;

public class Solution {

    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> q = new ArrayDeque<>();

        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0)
                    result.add(node.val);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 3, 9, 20, -1, -1, 15, 7 };
        TreeNode root = new TreeNode().generateTree(arr);

        List<Integer> result = solution.leftSideView(root);
        System.out.println(result);
    }
}
