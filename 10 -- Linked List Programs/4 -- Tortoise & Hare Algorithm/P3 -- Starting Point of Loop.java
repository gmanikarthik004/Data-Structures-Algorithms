class ListNode {
    int val;
    ListNode next;

    ListNode (int x) {
        this.val = x;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
                slowPtr = head;
                while(slowPtr != fastPtr) {
                    slowPtr = slowPtr.next;
                    fastPtr = fastPtr.next;
                }
                return slowPtr; // Loop Start
            }
        }

        return null;
    }
}