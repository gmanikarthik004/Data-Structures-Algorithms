class Node {
    int data; // Data Value
    Node next; // Reference to the next node
    
    Node (int data1, Node nextRef) {
        this.data = data1;
        this.next = nextRef;
    }

    Node (int data1) {
        this.data = data1;
        this.next = null;
    }
}

class Main {
    public static void main(String args[]) {
        int[] arr = {1, 3, 5, 7};
        
        Node y = new Node(arr[2]);
        System.out.println("Address: " + y); // Memory Address
        System.out.println("Value: " + y.data); // Value stored at that m/my address
    }
}