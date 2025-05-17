class Node {
    int data; 
    Node next;
    Node prev;
    
    Node (int d, Node nxt, Node pre) {
        this.data = d;
        this.next = nxt;
        this.prev = pre;
    }
    
    Node (int d) {
        this.data = d;
        this.next = null;
        this.prev = null;
    }
}

class Main {
    public static void printDLL(Node head) {
        Node temp = head;
        
        while(temp != null) {
            System.out.print(temp.data);
            if(temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
    }
    public static Node convertToDLL(Node head, int[] arr) {
        Node prevNode = head;
        
        for(int i = 1; i < arr.length; i++) {
            Node tempNode = new Node(arr[i], null, prevNode);
            prevNode.next = tempNode;
            prevNode = tempNode;
        }
        
        return head;
    }
    public static Node deleteAtHead(Node head) {
        if(head == null || head.next == null) return null;
        
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        
        return head;
    }
    public static Node deleteAtTail(Node head) {
        if(head == null || head.next == null) return null;
        
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null; // optional
        return head;
    }
    public static Node deleteAtK(Node head, int K) {
        if(head == null) return null;
        
        int cnt = 0;
        Node temp = head;
        while(temp != null) {
            cnt++;
            if(cnt == K) break;
            temp = temp.next;
        }
        
        Node prevN = temp.prev;
        Node frontN = temp.next;
        
        if(prevN == null && frontN == null) {
            return null; // Single-element
        }
        else if(prevN == null) {
            return deleteAtHead(temp); // Delete head
        }
        else if(frontN == null) {
            head = deleteAtTail(head); // Delete tail
        }
        else {
            prevN.next = frontN;
            frontN.prev = prevN;
            // temp.next = null;
            // temp.prev = null; 
        }
        
        return head;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        int K = 3;
        Node head = new Node(arr[0]);
        
        head = convertToDLL(head, arr);
        System.out.println("DLL Before: ");
        printDLL(head);
        
        System.out.println();
        
        head = deleteAtK(head, K);
        System.out.println("DLL After: ");
        printDLL(head);
    }
}