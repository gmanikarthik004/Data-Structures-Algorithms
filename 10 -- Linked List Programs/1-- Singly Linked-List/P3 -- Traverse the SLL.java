class Node {
    int data; // Data Value
    Node next; // Reference to the next node
    
    Node (int data1) {
        this.data = data1;
        this.next = null;
    }
}

class Main {
    static Node convertArr2LL(int[] arr) {
        Node headNode = new Node(arr[0]);
        Node mover = headNode;
        
        for(int i = 1; i < arr.length; i++) {
            Node tempNode = new Node(arr[i]);
            mover.next = tempNode;
            mover = tempNode;
        }
        
        return headNode;
    }
    
    public static void main(String args[]) {
        int[] arr = {12, 24, 36, 48};
        
        Node headNode = convertArr2LL(arr); // Starting node of LL
        System.out.println("Linked-List: ");
        Node tempNode = headNode;
        
        while(tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }
}