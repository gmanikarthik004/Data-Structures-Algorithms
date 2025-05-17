class Node {
    int data;
    Node next;
    
    Node (int d, Node nxt) {
        this.data = d;
        this.next = nxt;
    }
    Node (int d) {
        this.data = d;
        this.next = null;
    }
}

class Main {
    static Node convertToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        
        for(int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        
        return head;
    }
    
    static void printLL(Node head) {
        Node temp = head;
        
        while(temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print("->");
            temp = temp.next;
        }
    }
    
    static Node insertAtTail(Node head, int val) {
        Node temp = head;
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = new Node(val);
        return head;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        int val = 50;
        
        Node head = convertToLL(arr);
        System.out.println("Before Insertion at tail: ");
        printLL(head);
        
        System.out.println();
        
        head = insertAtTail(head, val);
        System.out.println("After Insertion at tail: ");
        printLL(head);
    }
}