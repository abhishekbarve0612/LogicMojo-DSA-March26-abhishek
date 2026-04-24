// 	•	Given a binary tree
// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.

package inClass.week5.populateNextRightPointers;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public Node generateTree(int[] arr) {
        Node root = new Node(arr[0]);
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);

        for (int i = 1; i < arr.length; i += 2) {
            Node node = q.poll();

            if (arr[i] != -1) {
                node.left = new Node(arr[i]);
                q.offer(node.left);
            }

            if (arr[i + 1] != -1) {
                node.right = new Node(arr[i + 1]);
                q.offer(node.right);
            }
        }

        return root;
    }

    public void print(Node root) {
        while (root != null) {
            Node temp = root;
            while (temp != null) {
                System.out.print(temp.val + " " + (temp.next != null ? temp.next.val : "null"));
                temp = temp.next;
            }
            System.out.println();
            root = root.left;
        }
    }
};

public class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new ArrayDeque<>();

        if (root != null)
            q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = q.peek();
                }

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        Node root = new Node().generateTree(arr);

        Node result = solution.connect(root);
        result.print(result);

    }
}