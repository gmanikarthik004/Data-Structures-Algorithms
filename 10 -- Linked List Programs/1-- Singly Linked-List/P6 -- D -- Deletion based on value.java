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
    
    static Node deleteAtValue(Node head, int val) {
        if(head == null) return null;
        if(head.data == val) return head.next;
        
        Node prev = null;
        Node temp = head;
        while(temp != null) {
            if(temp.data == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        int val = 30;
        
        Node curHead = convertToLL(arr);
        System.out.println("Before Deletion of given value: ");
        printLL(curHead);
        
        System.out.println();
        
        Node newHead = deleteAtValue(curHead, val);
        System.out.println("After Deletion of given value: ");
        printLL(newHead);
    }
}