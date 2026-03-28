package inClass.week4.cloneWithRandomPointer;

// Clone a linked list with next and random pointer.

class Node {
    public int val;
    public Node next;
    public Node random;

    Node(int data) {
        this.val = data;
        this.next = null;
        this.random = null;
    }

    public static Node createLinkedList(int[] arr) {
        if (arr.length == 0)
            return null;

        Node head = new Node(arr[0]);
        Node temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }

        return head;
    }
}

public class Solution {
    public Node cloneLinkedList(Node head) {

        Node dummy = new Node(-1);
        dummy.next = head;

        Node temp = head;

        while (temp != null) {
            Node cloneNode = new Node(temp.val);
            Node next = temp.next;
            temp.next = cloneNode;
            cloneNode.next = next;
            temp = next;
        }

        temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node tail = dummy;

        temp = head;

        while (temp != null) {
            Node next = temp.next.next;
            Node cloned = temp.next;
            tail.next = cloned;
            tail = cloned;

            temp.next = next;
            temp = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr = new int[] { 1, 2, 3, 4, 5 };
        Node head = Node.createLinkedList(arr);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        Solution sol = new Solution();

        Node tempNode = head;

        Node clonedHead = sol.cloneLinkedList(head);

        while (tempNode != null) {
            System.out.print("---" + tempNode.val + " ");
            System.out.print(tempNode.random.val + "---");
            tempNode = tempNode.next;
        }

        System.out.println("\ncloned --->");
        while (clonedHead != null) {
            System.out.print("---" + clonedHead.val + " ");
            System.out.print(clonedHead.random.val + "---");
            clonedHead = clonedHead.next;
        }

    }
}
