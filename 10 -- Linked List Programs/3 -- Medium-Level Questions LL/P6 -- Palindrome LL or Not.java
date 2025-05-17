class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseLL(head.next);
        ListNode frontNode = head.next;
        frontNode.next = head;
        head.next = null;

        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        // Step-1 Reach firstHalf of LL
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Step-2 Reverse the nextHalf of LL
        ListNode newHead = reverseLL(slowPtr.next);

        // Step-3 Comparison
        ListNode firstPtr = head; ListNode secondPtr = newHead;
        while(secondPtr != null) {
            if(firstPtr.val != secondPtr.val) {
                reverseLL(newHead);
                return false;
            }
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        reverseLL(newHead);
        return true;
    }
}