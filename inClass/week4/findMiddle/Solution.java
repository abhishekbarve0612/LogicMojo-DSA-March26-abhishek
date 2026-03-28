package inClass.week4.findMiddle;
// Given the head of a singly linked list, return the middle node of the
// linked list. If there are two middle nodes, return the second middle
// node.

import inClass.week4.Node;

class Solution {
    public Node getMiddleNode(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        Node head = Node.createLinkedList(arr);

        Solution sol = new Solution();
        Node middleNode = sol.getMiddleNode(head);

        System.out.println(middleNode.data);
    }


}