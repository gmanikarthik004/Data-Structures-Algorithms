class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode findKthNode(ListNode temp, int k) {
        k = k - 1;
        while(temp != null && k > 0) {
            temp = temp.next;
            k--;
        }

        return temp; 
    }

    public ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) 
            return head;

        ListNode newHead = reverseLL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if(kthNode == null) {
                if(prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverseLL(temp);

            if(temp == head) {
                head = kthNode;
            }
            else {
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextNode;
        }

        return head;
    }
}