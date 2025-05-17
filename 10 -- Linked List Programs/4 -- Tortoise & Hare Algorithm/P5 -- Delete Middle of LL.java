class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        fastPtr = fastPtr.next.next;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        slowPtr.next = slowPtr.next.next;
        return head;
    }
}