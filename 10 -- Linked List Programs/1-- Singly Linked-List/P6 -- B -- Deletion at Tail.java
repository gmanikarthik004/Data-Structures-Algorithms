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
    
    static Node deleteAtTail(Node head) {
        if(head == null || head.next == null) return null;
        
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        
        temp.next = null;
        return head;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        
        Node curHead = convertToLL(arr);
        
        System.out.println("Before Deletion at Tail: ");
        printLL(curHead);
        
        System.out.println();
        Node newHead = deleteAtTail(curHead);
        
        System.out.println("After Deletion at Tail: ");
        printLL(newHead);
    }
}