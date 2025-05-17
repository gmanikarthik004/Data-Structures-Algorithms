class Node {
    int data;
    Node next;
    
    Node()
    {
        this.data = 0;
        this.next = null;
    }
    
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    
    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

class Solution
{
    public static Node sortList(Node head) {
        if(head == null || head.next == null) return head;
 
        Node zeroHead = new Node(-1);
        Node zero = zeroHead;
 
        Node oneHead = new Node(-1);
        Node one = oneHead;
 
        Node twoHead = new Node(-1);
        Node two = twoHead;
 
        Node tempN = head;
 
        while(tempN != null) {
            if(tempN.data == 0) {
                zero.next = tempN;
                zero = zero.next;
            }
            else if(tempN.data == 1) {
                one.next = tempN;
                one = one.next;
            }
            else {
                two.next = tempN;
                two = two.next;
            }
 
            tempN = tempN.next;
        }
 
        zero.next = (oneHead.next != null)? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;
 
        return zeroHead.next; // As newHead of sorted LL
    }
}