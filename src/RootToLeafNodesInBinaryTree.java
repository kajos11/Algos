import java.util.Stack;

public class RootToLeafNodesInBinaryTree {

	
	
	public static void printRootToLeaf(Node root,int[] arr, int length) {
		
		if(root == null) {
			return;
		}
		arr[length] = root.data;
		length++;
		if(root.left == null && root.right == null) {
			printArr(arr,length);
			return;
		}
		printRootToLeaf(root.left,arr,length);
		printRootToLeaf(root.right,arr,length);
	}
	
	public static void printArr(int[] arr, int length) {
		for(int i = 0 ; i < length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.right = new Node(12);
		tree.root.right.right = new Node(13);
		tree.root.right.left = new Node(11);
		tree.root.right.left.left = new Node(2);
		tree.root.right.left.right = new Node(3);
		tree.root.right.right.left = new Node(15);                 
		tree.root.right.right.right = new Node(16);		
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(11);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.left.left= new Node(13);
		tree.root.left.right = new Node(12);
		tree.root.left.right.right = new Node(14);
		tree.root.left.right.right.right = new Node(15);
		int[] arr = new int[1000];
		printRootToLeaf(tree.root,arr,0);
	}
}
