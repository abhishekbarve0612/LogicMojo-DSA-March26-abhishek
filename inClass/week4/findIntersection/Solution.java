package inClass.week4.findIntersection;

import inClass.week4.Node;

// Given the heads of two singly linked-lists headA and headB, return the
// node at which the two lists intersect. If the two linked lists have no
// intersection at all, return null.
// For example, the following two linked lists begin to intersect at node c1

public class Solution {

    public Node getIntersectionNode(Node headA, Node headB) {

        int lenA = 0, lenB = 0;

        Node currA = headA, currB = headB;

        while (currA != null) {
            lenA++;
            currA = currA.next;
        }

        while (currB != null) {
            lenB++;
            currB = currB.next;
        }

        currA = headA;
        currB = headB;

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                currB = currB.next;
            }
        }

        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;


    }

    public static void main(String[] args) {
        int[] arrA = new int[] { 1, 2, 3 };
        int[] arrB = new int[] { 4, 5, 6, 7 };
        int[] arrC = new int[] { 8, 9, 10 };

        Node headA = Node.createLinkedList(arrA);
        Node headB = Node.createLinkedList(arrB);
        Node headC = Node.createLinkedList(arrC);

        headA.next.next.next = headC;
        headB.next.next.next.next = headC;

        Solution sol = new Solution();
        Node intersectionNode = sol.getIntersectionNode(headA, headB);

        if (intersectionNode != null) {
            System.out.println(intersectionNode.data);
        } else {
            System.out.println("No intersection");
        }



    }
    
}
