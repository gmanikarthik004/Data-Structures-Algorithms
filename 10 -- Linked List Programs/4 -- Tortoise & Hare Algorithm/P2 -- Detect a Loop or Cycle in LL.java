class ListNode {
    int val;
    ListNode next;

    ListNode (int x) {
        this.val = x;
    }
}

// BRUTE-FORCE SOLUTION T.C: O(N) && S.C: O(N)
/*
import java.util.*;
class Solution {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Boolean> mapp = new HashMap<>();
        ListNode temp = head;

        while(temp != null) {
            if(mapp.containsKey(temp)) 
                return true;
            mapp.put(temp, true);
            temp = temp.next;
        }

        return false;
    }
}
*/

// OPTIMAL SOLUTION T.C: O(N) && S.C: O(1)
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) return true;
        } 

        return false;
    }
}

