
public class MaxNoOfOnesInTwoDArray {

	public static void findMaxOne(int[][] arr) {
		
		int index_max = arr.length;
		int max_row = -1;
		boolean indexZeroFound = false;
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0; j < index_max; j++) {
				if(arr[i][j] == 1) {
					indexZeroFound = j == 0 ? true : indexZeroFound; 
					index_max = j;
					max_row = i;
					break;
				}
			}
			if(indexZeroFound) {
				break;
			}
		}
		System.out.println("Highest 1's Row: "+(max_row+1)+", max no of 1's count: "+(arr.length-index_max));
	}
	
	static void print(int[][] arr) {
		
		System.out.println("Printing given array:");
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args) {
		int[][] arr = new int[][] {{0,0,0,0,1,1},{1,1,1,1,1,1},{0,0,0,0,0,0},{0,0,0,1,1,1},{0,0,1,1,1,1},{0,0,0,0,0,1}};
		print(arr);
		findMaxOne(arr);
		
	} 
}
