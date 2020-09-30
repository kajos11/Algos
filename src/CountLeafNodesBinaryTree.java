
public class CountLeafNodesBinaryTree {
	
	
	public static int leafCount(Node root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return leafCount(root.left)+leafCount(root.right);
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
		int leafCount = leafCount(tree.root);
		System.out.println("Leaf Count is: "+leafCount);
	}

}

