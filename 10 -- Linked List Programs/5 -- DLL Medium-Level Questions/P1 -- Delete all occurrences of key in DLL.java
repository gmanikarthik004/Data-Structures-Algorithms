class Node {
    int data;
    Node next;
    Node prev;

    Node (int x) {
        this.data = x;
        this.prev = null;
        this.next = null;
    }
}

class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        Node temp = head;

        while(temp != null) {
            if(temp.data == k) {
                if(temp == head) {
                    head = head.next;
                }

                Node nextNode = temp.next;
                Node prevNode = temp.prev;

                if(nextNode != null) nextNode.prev = prevNode;
                if(prevNode != null) prevNode.next = nextNode;

                temp = nextNode;
            }
            else
            temp = temp.next;
        }

        return head;
    }
}