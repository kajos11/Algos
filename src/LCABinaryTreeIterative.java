import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class LCABinaryTreeIterative {
    
    //using backtracking of parent nodes    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	Map<TreeNode,TreeNode> parentsMap = new HashMap<TreeNode, TreeNode>();
    	
    	stack.add(root);
    	parentsMap.put(root, null);
    	
    	/*
    	 * loop until both p and q are in the map
    	 */
    	while( !parentsMap.containsKey(p)  ||  !parentsMap.containsKey(q)) {
    		TreeNode currentNode = stack.pop();
    		if(currentNode.left != null) {
    			stack.add(currentNode.left);
    			parentsMap.put(currentNode.left, currentNode);
    		}
    		if(currentNode.right != null) {
    			stack.add(currentNode.right);
    			parentsMap.put(currentNode.right, currentNode);
    		}
    	}
    	
    	// set to get the p parents
    	Set<TreeNode> pParents = new HashSet<TreeNode>();
    	
    	// backtrack the p parents till null 
    	while(p != null) {
    		pParents.add(p);
    		p = parentsMap.get(p);
    	}
    	
    	// backtrack the q parents till we find the common ancestor
    	while(!pParents.contains(q)) {
    		q = parentsMap.get(q);
    	}
    	return q;
    	
    }
    
}