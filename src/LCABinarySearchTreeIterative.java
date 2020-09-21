
/**
 * Finding LCA of Binary Search tree using iterative approach.
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

class LCABinarySearchTreeIterative {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //iterative
        if(root == null) return null;
        while(root != null){
            
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
        return null;
        
        
        
    }
}