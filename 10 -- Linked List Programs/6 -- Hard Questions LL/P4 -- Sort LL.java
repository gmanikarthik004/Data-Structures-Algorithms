class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // MiddleNode
    }

    public ListNode merge2LL(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null) temp.next = list1;
        else temp.next = list2;

        return dummyNode.next; 
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middleNode = findMiddle(head);

        ListNode leftNode = head;
        ListNode rightNode = middleNode.next;
        middleNode.next = null;

        leftNode = sortList(leftNode);
        rightNode = sortList(rightNode);
        return merge2LL(leftNode, rightNode);
    }
}