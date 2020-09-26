import java.util.Scanner;


public class BinaryTreeChildrenSum {

	static boolean isChildSum(Node root) {
		if(root == null) {
			return true;
		}
		if(root.left != null){
			if(root.right != null) {
				if(root.left.data + root.right.data != root.data){
					return false;
				}
			}
			else if(root.left.data != root.data){
				return false;
			
			}
		}
		if(root.right != null) {
			if(root.left != null){
				if(root.left.data + root.right.data != root.data){
					return false;
				}
			}
			else if(root.right.data != root.data){
				return false;
			
			}
		}
		return isChildSum(root.left) && isChildSum(root.right);
	}
	
	
	/* driver program to test the above functions */
    public static void main(String[] args)  
    { 
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(2); 
        if (isChildSum(tree.root)) 
            System.out.println("The given tree satisfies children"
                    + " sum property"); 
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property"); 
    } 

}
