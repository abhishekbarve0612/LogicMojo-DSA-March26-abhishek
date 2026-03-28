package inClass.week4.removeDuplicates;

import inClass.week4.Node;

// 1.     Remove duplicate elements from sorted linked list.

// For example, if the given linked list is 1->2->2->2->5->6 then the output should be 1->2->5->6.

class Solution {
    public Node removeDuplicates(Node head) {
        Node first = head;
        Node second = head;

        while (second != null) {
            if (first.data == second.data) {
                second = second.next;
            } else {
                first.next = second;
                first = second;
                second = second.next;
            }
        }

        if (first != null && first.next != null && first.data == first.next.data) {
            first.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 2, 5, 6, 6, 7, 7, 8, 8, 9, 9 };
        Node head = Node.createLinkedList(arr);

        Solution sol = new Solution();
        Node result = sol.removeDuplicates(head);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }
}