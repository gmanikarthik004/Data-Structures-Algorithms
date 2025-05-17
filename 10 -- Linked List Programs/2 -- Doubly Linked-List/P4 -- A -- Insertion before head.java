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
    public static Node insertBeforeHead(Node head, int val) {
        Node newNode = new Node(val, head, null);
        head.prev = newNode;
        return newNode;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        Node head = new Node(arr[0]);
        
        head = convertToDLL(head, arr);
        System.out.println("DLL Before: ");
        printDLL(head);
        
        System.out.println();
        
        head = insertBeforeHead(head, 50);
        System.out.println("DLL After: ");
        printDLL(head);
    }
}