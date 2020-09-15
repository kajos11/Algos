import java.util.ArrayList;
import java.util.List;

public class DetectCycleInLinkedList {
	
	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as: */
	    class Node {
	        int data;
	        Node next;
	    }
	

	boolean hasCycle(Node head) {
	    List<Node> li = new ArrayList<Node>();
	    while(head!= null && head.next != null){
	        if(li.contains(head)){
	            return true;
	        }
	        li.add(head);
	        head = head.next;
	    }
	    return false;
	}

}
