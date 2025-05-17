class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// ITERATIVE-SOLUTION: T.C: O(N) && S.C: O(1)
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode tempN = head;
        ListNode prevN = null;

        while(tempN != null) {
            ListNode frontN = tempN.next;
            tempN.next = prevN;
            prevN = tempN;
            tempN = frontN;
        }

        return prevN;
    }
}
*/

// RECURSIVE-SOLUTION: T.C: O(N) && S.C: O(N)
/*
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) // Single-Node
            return head;
        
        ListNode newNode = reverseList(head.next);
        ListNode frontN = head.next;
        frontN.next = head;
        head.next = null;

        return newNode;
    }
}
*/

// ITERATIVE WAS SIMPLER TO UNDERSTAND BUT AFTER SOME EFFORTS, 
// RECURSIVE WILL MAKE YOU FEEL THE EASIER ONE.