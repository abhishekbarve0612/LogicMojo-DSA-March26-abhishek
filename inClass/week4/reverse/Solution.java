// package inClass.week4.reverse;
class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        Solution sol = new Solution();
        Node reversedHead = sol.reverseLinkedList(head);

        while (reversedHead != null) {
            System.out.print(reversedHead.data + " ");
            reversedHead = reversedHead.next;
        }
    }
}