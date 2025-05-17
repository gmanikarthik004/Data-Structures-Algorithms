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