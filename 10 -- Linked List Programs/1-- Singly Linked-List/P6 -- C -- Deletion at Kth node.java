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
    
    static Node deleteAtK(Node head, int K) {
        if(head == null) return null;
        if(K == 1) return head.next;
        
        int cnt = 0;
        Node prev = null;
        Node temp = head;
        
        while(temp != null) {
            cnt++;
            if(cnt == K) {
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
        int K = 2;
        
        Node curHead = convertToLL(arr);
        System.out.println("Before Deletion at Kth-position: ");
        printLL(curHead);
        
        System.out.println();
        
        Node newHead = deleteAtK(curHead, K);
        System.out.println("After Deletion at Kth-position: ");
        printLL(newHead);
    }
}