class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1; ListNode t2 = list2;
        ListNode dummyNode = new ListNode(-1);
        ListNode tempNode = dummyNode;

        while(t1 != null && t2 != null) {
            if(t1.val < t2.val) {
                tempNode.next = t1;
                tempNode = t1;
                t1 = t1.next;
            }
            else {
                tempNode.next = t2;
                tempNode = t2;
                t2 = t2.next;
            }
        }

        if(t1 != null) tempNode.next = t1;
        else tempNode.next = t2;

        return dummyNode.next; // NewHead
    }
}