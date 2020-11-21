
public class TreeBFSTest {
	
	
	public static void bfs(Node node, int level, int actualLevel) {
		if(node == null) return;
		if(level == actualLevel) {
			System.out.println("level "+actualLevel+": "+node.data);
		}
		bfs(node.left, level+1, actualLevel);
		bfs(node.right, level+1, actualLevel);
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
        
        for(int i = 1 ; i <= 6; i++) {
        	bfs(root, 1, i);
        }
		
		
	}
	

}

