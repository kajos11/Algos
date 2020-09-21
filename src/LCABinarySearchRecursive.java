//recursive solution

/**
 * Finding LCA of Binary Search tree using recursive approach.
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class LCABinarySearchRecursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if(root == null){return null;}
    	if(root.val > p.val && root.val > q.val){
    	    return lowestCommonAncestor(root.left, p, q);
    	}
    	if(root.val < p.val && root.val < q.val){
    	    return lowestCommonAncestor(root.right, p, q);
    	}
    	return root;
    }
}