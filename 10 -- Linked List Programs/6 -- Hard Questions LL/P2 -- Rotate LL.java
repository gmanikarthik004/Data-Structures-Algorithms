class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode findNthNode(ListNode temp, int k) {
        int cnt = 1;

        while(temp != null) {
            if(cnt == k) return temp;
            cnt++;
            temp = temp.next;
        }

        return temp;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;

        ListNode tail = head;
        int len = 1;

        while(tail.next != null) { // Length of LL & TailNode
            len++;
            tail = tail.next;
        }

        if(k % len == 0) return head; // Exact multiple of Length

        k = k % len; // Updated k

        tail.next = head;

        ListNode nthNode = findNthNode(head, len - k);

        head = nthNode.next; // Updated head
        nthNode.next = null;

        return head;
    }
}