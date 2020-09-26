import java.util.Scanner;

public class BinaryTreeHeightBalanced {

	static boolean isHeightBalanced(Node root) {
		if(root == null) {
			return true;
		}
		int lh = findHeight(root.left);
		int rh = findHeight(root.right);
		if(Math.abs(lh-rh) <= 1 && isHeightBalanced(root.left) && isHeightBalanced(root.right)) {
			return true;
		}
		return false;
	}
	
	static int findHeight(Node root) {
		if(root == null) { return 0;}
		int lh = findHeight(root.left);
		int rh = findHeight(root.right);
		return (lh > rh) ? lh+1 : rh+1;
	}
	
	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
	
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean isBalanced = isHeightBalanced(root);
        System.out.println(isBalanced);
    }	
}
