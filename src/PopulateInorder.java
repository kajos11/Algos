import java.util.Scanner;

class NextNode{
	
	int data;
	NextNode left;
	NextNode right;
	NextNode next;
	
	public NextNode(int data) {
		this.data = data;
	}
}
public class PopulateInorder {

	public static NextNode next = null;
	
	
	static void inorder(NextNode root){
		
		if(root == null) {
			return;
		}
		inorder(root.right);
		if(next != null) {
			System.out.print(root.data+"("+next.data+")-");
		}
		else {
			System.out.print(root.data+"(NULL)-");
		}
		root.next = next;
		next = root;
		
		inorder(root.left);
		
	}
	private static void printNextNodesInorder(NextNode root) {
		
		if(root == null) {return;}
		printNextNodesInorder(root.left);
		if(root.next != null) {
			System.out.print(root.next.data+"-");
		}
		printNextNodesInorder(root.right);
		
		
	}
	public static void main(String[] args) {
		NextNode root = new NextNode(5);
        root.left = new NextNode(10);
        root.left.left = new NextNode(12);
        root.left.left.right = new NextNode(22);
        root.left.right = new NextNode(15);
        root.right = new NextNode(18);
        root.right.right = new NextNode(17);
        inorder(root);
        System.out.println("");
        System.out.println(root.data);
        printNextNodesInorder(root);
	}


	
	

}
