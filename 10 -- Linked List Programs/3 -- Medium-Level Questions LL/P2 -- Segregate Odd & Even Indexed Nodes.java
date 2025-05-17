class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode oddPtr = head;
        ListNode evenPtr = head.next;
        ListNode evenHead = head.next;

        while(evenPtr != null && evenPtr.next != null) {
            oddPtr.next = oddPtr.next.next;
            evenPtr.next = evenPtr.next.next;

            oddPtr = oddPtr.next; // Update oddPtr
            evenPtr = evenPtr.next; // Update evenPtr
        }

        oddPtr.next = evenHead; // Attach the oddPtr -> evenPtr

        return head;
    }
}