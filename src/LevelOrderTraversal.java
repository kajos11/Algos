
/**
 * 
 * Tree BFS
 *
 */
public class LevelOrderTraversal {

	
	
	static void levelOrder(Node node){
		int height = getHeight(node);
		System.out.println("height is: "+height);
		for(int i = 1; i <= height; i++) {
			printLevel(node, i);
			System.out.println("");
		}
	}
	
	static void printLevel(Node node, int level) {
		
		if(node == null) {
			return;
		}
		if(level == 1) {
			System.out.print(node.data+" ");
		}
		else if(level > 1) {
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
		
		
	}
	
	static int getHeight(Node node) {
		
		if(node == null) {return 0;}
		
		int leftHeight = 1 + getHeight(node.left);
		int rightHeight = 1 + getHeight(node.right);
		
		return Math.max(leftHeight, rightHeight);
		
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(5);
        root.left = new Node(10);
        root.left.left = new Node(12);
        root.left.left.right = new Node(22);
        root.left.right = new Node(15);
        root.right = new Node(18);
        root.right.right = new Node(17);
        root.right.right.left = new Node(13);
        root.right.right.left.right = new Node(14);
        levelOrder(root);
        
	}

}
