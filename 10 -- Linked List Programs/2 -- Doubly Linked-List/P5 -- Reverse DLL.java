// import java.util.Stack;
class Node {
    int data;
    Node next;
    Node prev;
    
    Node (int d, Node n, Node p) {
        this.data = d;
        this.next = n;
        this.prev = p;
    }
    
    Node (int d) {
        this.data = d;
        this.next = this.prev = null;
    }
}

class Main {
    public static Node convertArr2DLL(Node head, int arr[]) {
        Node temp = head;
        
        for(int i = 1; i < arr.length; i++) {
            Node curr = new Node(arr[i], null, temp);
            temp.next = curr;
            temp = curr;
        }
        
        return head;
    }
    public static void printDLL(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data);
            if(temp.next != null) System.out.print("<->");
            temp = temp.next;
        }
    }
    /*public static Node reverseDLL1(Node head) {
        Stack<Integer> st = new Stack<>();
        
        Node temp = head;
        while(temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        
        temp = head;
        while(temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        
        return head;
    }
    */
    public static Node reverseDLL2(Node head) {
        if(head == null || head.next == null) return head;
        
        Node last = null;
        Node curr = head;
        
        while(curr != null) {
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            
            curr = curr.prev;
        }
        
        return last.prev; // As newHead
    }
    
    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40};
        Node head = new Node(arr[0]);
        
        head = convertArr2DLL(head, arr);
        System.out.println("DLL: ");
        printDLL(head);
        
        System.out.println();
        
        // head = reverseDLL1(head); // Using Stack
        head = reverseDLL2(head); // Reversing Ptrs
        System.out.println("DLL: ");
        printDLL(head);
    }
}