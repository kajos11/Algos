import java.util.HashMap;
import java.util.Map;

class CustomNode{
	
	int data;
	CustomNode left;
	CustomNode right;
	CustomNode next;
	
	public CustomNode(int data) {
		this.data = data;
	}
}

public class BinaryTreeConnectNodesAtSameLevel {

	public static Map<Integer, CustomNode> map= new HashMap<Integer, CustomNode>();
	public static int max_level = 0;
	public static void connectSameLevel(CustomNode node, int depth) {
		
		if(node == null) {
			return;
		}
		connectSameLevel(node.right,depth+1);
		connectSameLevel(node.left,depth+1);
		if(map.containsKey(depth)) {
			node.next = map.get(depth);
		}
		map.put(depth, node);
	}
	
	public static void printData(CustomNode node, int level) 
    { 
        // Base Case 
        if (node == null) 
            return; 
		// If this is the first node of its level 
        if (max_level < level) {
        	System.out.println();
            CustomNode temp = node;
            while(temp != null) {
            	System.out.print(" " + temp.data);	
            	temp = temp.next;
            }
            max_level = level; 
        } 
        // Recur for left and right subtrees 
        printData(node.left, level + 1); 
        printData(node.right, level + 1); 
    } 
	
	
	public static void main(String[] args) {
		CustomNode root = new CustomNode(5);
        root.left = new CustomNode(10);
        root.left.left = new CustomNode(12);
        root.left.left.right = new CustomNode(22);
        root.left.right = new CustomNode(15);
        root.right = new CustomNode(18);
        root.right.right = new CustomNode(17);
        root.right.right.left = new CustomNode(13);
        root.right.right.left.right = new CustomNode(14);
        connectSameLevel(root, 0);
        printData(root, 0);

	}

}
