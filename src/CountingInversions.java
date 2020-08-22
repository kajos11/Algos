
public class CountingInversions {

	public static void main(String[] args) {
		//int[] arr = new int[] {1,1,1,2,2};
		int[] arr = new int[] {7,5,3,1};
		
		//printArray(arr);
		sort(arr, 0, arr.length-1);
		System.out.println("inversions: "+inversions);
	}
	
	static long inversions = 0;
	
	public static void sort(int[] arr, int s, int e) {
		if(s < e) {
			int m = (s + e) / 2;
			System.out.println("m: "+m);
			sort(arr, s, m);
			sort(arr, m+1, e);
			merge(arr, s, m, e);
		}
		printArray(arr);
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i]);
		}
		System.out.println("");
	}
	
	public static void merge(int[] arr, int s, int m, int e) {
		
		//size of first array
		int n = m - s + 1;
		//size of second array
		int n2 = e - m;
		
		System.out.println("s: "+s+" m: "+m+" e: "+e+" n:"+n+" n2:"+n2);
		
		int[] L = new int[n];
		int[] R = new int[n2];
		
		//copy left side to temp array
		for(int i = 0; i < n ; i++) {
			L[i] = arr[i + s];
		}
		//copy right side to temp array
		for(int j = 0; j < n2 ; j++) {
			R[j] = arr[j+m+1];
		}
		
		int i = 0, j = 0;
		
		int k = s;
		
		//merge temp array
		while(i < n && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else if(L[i] > R[j]){
				arr[k] = R[j];
				j++;
				inversions +=  (n-i);
				System.out.println("inv: "+inversions);
			}
			k++;
		}
		
		//merge remaining left
		while(i < n) {
			arr[k] = L[i];
			i++;
			k++;
		}
		//merge remaining left
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	

}
