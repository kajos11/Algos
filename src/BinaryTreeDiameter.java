
public class BinaryTreeDiameter {

	static int getDiameterFromRoot(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = getLongestLeafPath(root.left);
		int rightHeight  = getLongestLeafPath(root.right);
		
		int lDia = getDiameterFromRoot(root.left);
		int rDia = getDiameterFromRoot(root.right);
		
		
		
		
		return Math.max(leftHeight+rightHeight+1, Math.max(lDia, rDia) );
	}

	static int getLongestLeafPath(Node node) {

		if (node == null) {
			return 0;
		}

		int lh = getLongestLeafPath(node.left);
		int rh = getLongestLeafPath(node.right);

		return Math.max(lh, rh) + 1;

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		/*
		tree.root = new Node(10);
		tree.root.left = new Node(8);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(1);
		tree.root.right.right = new Node(2);
		tree.root.right.right.left = new Node(10);
		tree.root.right.right.left.right = new Node(8);
		*/
		tree.root = new Node(10);
		tree.root.right = new Node(12);
		tree.root.left = new Node(8);
		tree.root.left.left = new Node(11);
		tree.root.left.left.left = new Node(8);
		tree.root.left.left.left.left= new Node(13);
		tree.root.left.right = new Node(12);
		tree.root.left.right.right = new Node(14);
		tree.root.left.right.right.right = new Node(15);
		
		
		int diameter = getDiameterFromRoot(tree.root);
		System.out.println("Diameter is: "+diameter);
	}

}

