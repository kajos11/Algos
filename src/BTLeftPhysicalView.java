/*
 
 Left Physical view of Binary Tree
 
 Example 1 : INPUT
       5
     /  \
    10   18
   /  \    \
  12   15   17
   \        /
   22     13
           \
           14
  
 OUTPUT: 5-10-12-22-14         
           
Example 2: INPUT
      20
     /  \
    31   32
   /  \    
  33   38   
   \   /     
   66  39   
        \   
         77  
  
 OUTPUT: 20-31-33-66-77  
 */
public class BTLeftPhysicalView {

	//storing the value of node if not present in the array already
	static int[] leftView(Node node, int[] arr, int level){
		
		if(node == null) {return arr;}
		//System.out.print("arr: ");print(arr);
		//System.out.println("data: "+node.data+" level: "+level);
		if(arr[level-1] == 0) {
			System.out.print(node.data+"+-+");
		}
		arr[level-1] = node.data;
		arr = leftView(node.left, arr, level+1);
		arr = leftView(node.right, arr, level+1);
		return arr;
		
	}
	
	/*
	 * static void print(int[] arr) { for(int i=0; i <arr.length; i++) {
	 * System.out.print(arr[i]+"->"); } System.out.println(""); }
	 */
	
	static int getHeight(Node node) {
		if(node == null) return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	
	public static void main(String[] args) {
		/*Node root = new Node(5);
        root.left = new Node(10);
        root.left.left = new Node(12);
        root.left.left.right = new Node(22);
        root.left.right = new Node(15);
        root.right = new Node(18);
        root.right.right = new Node(17);
        root.right.right.left = new Node(13);
        root.right.right.left.right = new Node(14);*/
		Node root = new Node(20);
        root.left = new Node(31);
        root.left.left = new Node(33);
        root.left.left.left = new Node(66);
        root.left.right = new Node(38);
        root.left.right.left = new Node(39);
        root.left.right.left.right = new Node(77);
        root.right = new Node(32);
        root.right.right = new Node(40);
		
        int height = getHeight(root);
        int[] arr = new int[height];
        leftView(root,arr,1);
        
	}

}
