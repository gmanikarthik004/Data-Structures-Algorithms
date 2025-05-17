class Node {
    int data;
    Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
}

// BRUTE FORCE
/*import java.util.*;
public class Solution
{
    public static int lengthOfLoop(Node head) {
        HashMap<Node, Integer> mpp = new HashMap<>();
        Node tempN = head; int timer = 1;

        while(tempN != null) {
            if(mpp.containsKey(tempN)) {
                int val = mpp.get(tempN);
                return timer - val;
            }
            mpp.put(tempN, timer);
            timer++;
            tempN = tempN.next;
        }

        return 0;
    }
}
*/

// OPTIMAL SOLUTION
class Solution
{
    public static int lengthOfLoop(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if(slowPtr == fastPtr) {
                int len = 1; fastPtr = fastPtr.next;

                while(fastPtr != slowPtr) {
                    len++;
                    fastPtr = fastPtr.next;
                }

                return len;
            }
        }

        return 0;
    }
}