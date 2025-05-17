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
    
    // static Node insertAtHead(Node head, int val) {
    //     return new Node(val, head);
    // }
    
    public static void main(String args[]) {
        int[] arr = {20, 30, 40, 50};
        int val = 10;
        
        Node head = convertToLL(arr);
        System.out.println("Before Insertion at head: ");
        printLL(head);
        
        System.out.println();
        
        head = new Node(val, head);
        System.out.println("After Insertion at head: ");
        printLL(head);
    }
}