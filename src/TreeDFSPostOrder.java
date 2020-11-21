
public class TreeDFSPostOrder {

	
	
	public static void dfs(Node node) {
		
		if(node == null) {
			return;
		}
		dfs(node.left);
		dfs(node.right);
		System.out.print(node.data+"->");
		
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(18);
        root.left.right = new Node(13);
        root.left.left.right = new Node(14);
        root.left.left.right.left = new Node(6);
        
        root.right = new Node(14);
        root.right.right = new Node(30);
        root.right.left = new Node(19);
        root.right.right.left = new Node(31);
        root.right.right.left.right = new Node(28);
        root.right.right.left.right.left = new Node(20);
        
        dfs(root);
        

	}

}

