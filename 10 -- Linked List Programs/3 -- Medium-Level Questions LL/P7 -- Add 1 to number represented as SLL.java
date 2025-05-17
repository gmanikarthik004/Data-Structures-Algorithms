class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
      }
}

class Solution {
	public static int helper(Node temp) {
		if(temp == null) // Base-Case
			return 1;

		int carry = helper(temp.next);
		temp.data = temp.data + carry;
		if(temp.data < 10) {
			return 0; // 0-carry
		}
		temp.data = 0;
		return 1;
	}

	public static Node addOne(Node head) {
		int finalCarry = helper(head);

		if(finalCarry == 1) {
			Node newNode = new Node(1);
			newNode.next = head;
			return newNode;
		}

		return head;
	}
}