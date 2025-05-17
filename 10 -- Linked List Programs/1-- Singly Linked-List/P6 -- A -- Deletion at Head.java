class Node {
    int data;
    Node next;
    
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
    
    static Node deleteAtHead(Node head) {
        if (head == null) return null;
        return head.next;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        
        Node curhead = convertToLL(arr);
        
        System.out.println("Before Deletion at Head: ");
        printLL(curhead);
        
        Node newhead = deleteAtHead(curhead);
        System.out.println();
        
        System.out.println("After Deletion at Head: ");
        printLL(newhead);
    }
}