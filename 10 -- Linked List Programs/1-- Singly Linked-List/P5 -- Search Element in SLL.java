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
    static boolean findElement(Node headNode, int key) {
        Node temp = headNode;
        
        while(temp != null) {
            
            if(temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        
        return false;
    }
    public static void main(String args[]) {
        int[] arr = {12, 24, 36, 48};
        int key = 48;
        
        Node headNode = convertArr2LL(arr); // Starting node of LL
        if(findElement(headNode, key)) {
            System.out.println("Yes, exists");
        }
        else {
            System.out.println("Doesn't exists");
        }
    }
}