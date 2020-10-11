
/**
 * Definition for singly-linked list.*/
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
public class AddTwoNumbers {
	
	public static void main(String[] args) {
		/*
		 * ListNode l1 = new ListNode(2); l1.next = new ListNode(4); l1.next.next = new
		 * ListNode(3); ListNode l2 = new ListNode(5); l2.next = new ListNode(6);
		 * l2.next.next = new ListNode(4); ListNode newNode = addTwoNumbers(l1,l2);
		 */
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		ListNode newNode = addTwoNumbers(l1,l2);
		printNode(newNode);
	}
	public static void printNode(ListNode node) {
		while(node!=null) {
			System.out.print(node.val+" ");
			node =node.next;
		}
		System.out.println("");
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(0);
		ListNode p = l1, q = l2, curNode = head;
		int carry = 0;
		while(p != null || q != null) {
			int a = p != null ? p.val : 0;
			int b = q != null ? q.val : 0;
			int sum = a + b + carry;
			carry = sum / 10;
			curNode.next = new ListNode(sum % 10);
			p = p != null ? p.next : p;
			q = q != null ? q.next : q;
			curNode = curNode.next;
		}
		if(carry > 0 ) {
			curNode.next = new ListNode(carry);
		}
		
		
		return head.next;
	}
	
    
}