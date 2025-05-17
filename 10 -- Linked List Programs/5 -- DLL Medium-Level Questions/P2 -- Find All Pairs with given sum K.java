import java.util.ArrayList;
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

class Solution {
    public static Node findTail(Node head) {
        if (head == null) return null; // null check
        Node temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        return temp;
    }
    
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        Node leftPtr = head;
        Node rightPtr = findTail(head);
        
        while(leftPtr != null && rightPtr != null && leftPtr != rightPtr && leftPtr.data < rightPtr.data) {
            int sum = leftPtr.data + rightPtr.data;
            
            if(sum == target) {
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(leftPtr.data); 
                ans.add(rightPtr.data);
                res.add(new ArrayList<>(ans));
                leftPtr = leftPtr.next;
                rightPtr = rightPtr.prev;
            }
            else if(sum < target) {
                leftPtr = leftPtr.next;
            }
            else {
                rightPtr = rightPtr.prev;
            }
        }
        
        return res;
    }
}
