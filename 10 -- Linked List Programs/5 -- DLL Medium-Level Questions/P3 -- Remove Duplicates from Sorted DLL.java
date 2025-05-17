class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

class Solution {
    public static Node uniqueSortedList(Node head) {
        Node tempNode = head;

        while (tempNode != null && tempNode.next != null) {
            Node nextNode = tempNode.next;

            while (nextNode != null && nextNode.data == tempNode.data) {
                nextNode = nextNode.next;
            }

            tempNode.next = nextNode;
            if (nextNode != null) nextNode.prev = tempNode;

            tempNode = tempNode.next;
        }

        return head;
    }
}
