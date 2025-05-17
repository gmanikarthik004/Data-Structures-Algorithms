class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public void insertCopyNodesInBetween(Node head) {
        Node tempNode = head;
        while(tempNode != null) {
            Node copyNode = new Node(tempNode.val);
            copyNode.next = tempNode.next;
            tempNode.next = copyNode;

            tempNode = tempNode.next.next;
        }
    }

    public void connectRandomPointers(Node head) {
        Node tempNode = head;
        while(tempNode != null) {
            Node copyNode = tempNode.next;
            
            if(tempNode.random != null) {
                copyNode.random = tempNode.random.next;
            }
            else {
                copyNode.random = null;
            }

            tempNode = tempNode.next.next;
        }
    }

    public Node extractClonedList(Node head) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        Node tempNode = head;

        while(tempNode != null) {
            // Creating new L.List
            res.next = tempNode.next;
            res = res.next;

            // Disconnecting & Going back to
            // initial state of L.List
            tempNode.next = tempNode.next.next;
            tempNode = tempNode.next;
        }

        return dummyNode.next; // New Head of ClonedLList
    }

    public Node copyRandomList(Node head) {
        insertCopyNodesInBetween(head);
        connectRandomPointers(head);
        return extractClonedList(head);
    }
}