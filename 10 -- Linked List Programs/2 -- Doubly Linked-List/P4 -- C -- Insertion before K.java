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
    public static Node insertBeforeK(Node head, int K, int val) {
        if(K == 1) return insertBeforeHead(head, val);

        int cnt = 0;
        Node tempN = head;
        while(tempN != null) {
            cnt++;
            if(cnt == K) break;
            tempN = tempN.next;
        }

        Node prevN = tempN.prev;
        Node newNode = new Node(val, tempN, prevN);
        prevN.next = tempN.prev = newNode;

        return head; 
    }
    
    public static void main(String args[]) {
        int[] arr = {10, 20, 30, 40};
        Node head = new Node(arr[0]);
        
        head = convertToDLL(head, arr);
        System.out.println("DLL Before: ");
        printDLL(head);
        
        System.out.println();
        
        head = insertBeforeK(head, 2, 100);
        System.out.println("DLL After: ");
        printDLL(head);
    }
}