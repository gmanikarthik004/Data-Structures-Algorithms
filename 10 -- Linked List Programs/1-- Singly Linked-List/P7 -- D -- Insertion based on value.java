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
    
    static Node insertAtVal(Node head, int val, int ele){
        if(head == null) return null;
        if(head.data == val) return new Node(ele, head);
        
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.data == val) {
                Node newNode = new Node(ele, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        
        return head;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 50};
        int val = 70, ele = 40;
        
        Node head = convertToLL(arr);
        System.out.println("Before Insertion at given value: ");
        printLL(head);
        
        System.out.println();
        
        head = insertAtVal(head, val, ele);
        System.out.println("After Insertion at given value: ");
        printLL(head);
    }
}