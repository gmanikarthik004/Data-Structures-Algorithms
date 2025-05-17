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
    
    static Node insertAtK(Node head, int K, int val) {
        if(head == null) return new Node(val);
        if(K == 1) return new Node(val, head);
        
        int cnt = 0;
        Node temp = head;
        while(temp != null) {
            cnt++;
            if(cnt == K - 1) {
                Node newNode = new Node(val);
                newNode.next = temp.next;
                temp.next = newNode;
            }
            
            temp = temp.next;
        }
        
        return head;
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 40, 50};
        int K = 3, val = 30;
        
        Node head = convertToLL(arr);
        System.out.println("Before Insertion at Kth-position: ");
        printLL(head);
        
        System.out.println();
        
        head = insertAtK(head, K, val);
        System.out.println("After Insertion at Kth-position: ");
        printLL(head);
    }
}