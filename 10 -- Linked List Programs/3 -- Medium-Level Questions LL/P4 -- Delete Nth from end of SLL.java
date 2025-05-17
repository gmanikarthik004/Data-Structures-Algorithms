class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        ListNode fastPtr = head; ListNode slowPtr = head;

        // Move fastPtr to N-steps ahead
        for(int i = 0; i < n; i++) {
            fastPtr = fastPtr.next;
        }

        if(fastPtr == null) return head.next; // Asked to delete headNode

        while(fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        slowPtr.next = slowPtr.next.next;

        return head;
    }
}