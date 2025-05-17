class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carry = 0;

        while(l1 != null || l2 != null) {
            int sum = carry;
            if(l1 != null) sum = sum + l1.val;
            if(l2 != null) sum = sum + l2.val; 

            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;

            curr.next = newNode;
            curr = curr.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(carry > 0) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        
        return dummyNode.next;
    }
}