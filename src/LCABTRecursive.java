
public class LCABTRecursive {
	
	
	static Node lcaNode;
	
	static int lca(Node node, int p, int q) {
		
		if(node == null) {
			return 0;
		}
		int lh = lca(node.left, p, q);
		int rh = lca(node.right, p, q);
		int mid = (node.data == p || node.data == q) ? 1 : 0;
		System.out.println(node.data);
		if(lh+rh+mid >= 2) {
			if(lcaNode == null)
				lcaNode = node;
		}
		return lh+rh+mid;
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
        int p = 22;
        int q = 14;
        lca(root, p , q);
        if(lcaNode != null)
        	System.out.println("lca of "+p+" and "+q+" is: "+lcaNode.data);
	}
}
