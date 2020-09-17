
import java.util.*;
import java.io.*;



class LCA {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	
	private static Stack<Node> stack = null;
	private static boolean foundFirstNode = false;
	private static boolean foundBothNode = false;
	
	static Node lca(Node root,int v1,int v2)
	{
	    //Decide if you have to call rekursively
	    //Samller than both
	    if(root.data < v1 && root.data < v2){
	        return lca(root.right,v1,v2);
	    }
	    //Bigger than both
	    if(root.data > v1 && root.data > v2){
	        return lca(root.left,v1,v2);
	    }

	    //Else solution already found
	    return root;
	}
	
	/*
	public static Node lca(Node root, int v1, int v2) {
		foundFirstNode = false;
		foundBothNode = false;
		stack = new Stack<Node>();
		calculateLCA(root, v1, v2);
		return stack.pop();
    }
	*/
	public static void calculateLCA(Node root, int v1, int v2) {
		
		if(root == null) {
			return;
		}
		if(foundBothNode) {
			return;
		}
		System.out.println(root.data+"=>");
		stack.push(root);
		
		if( (!foundFirstNode) && (root.data == v1 || root.data == v2)) {
			foundFirstNode = true;
		}
		else if(foundFirstNode && (root.data == v1 || root.data == v2)) {
			int popTillNodeValue = (root.data == v1) ? v2 : v1;
			while(stack.peek().data != popTillNodeValue) {
				stack.pop();
			}
			stack.pop();
			foundBothNode = true;
			return;
		}
		
			if(!foundBothNode) {
				calculateLCA(root.left, v1, v2);
			}
			if(!foundBothNode) {
				calculateLCA(root.right, v1, v2);
			}
			
			
			if(root.data != v1 && root.data != v2 && !foundBothNode && stack.peek().data != v1 && stack.peek().data != v2) {
				stack.pop();
			}
			
		
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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}
