import java.util.Scanner;

/*
 * Count ways to reach the nth stair using step 1, 2, 3
 */
public class WayToReachNStepsInThreeStepsMax {
	
	
	public static int count(int n) {
		
		if(n == 0 || n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		return count(n-1)+count(n-2)+count(n-3);
	}
	

	public static void main(String[] args) {
		System.out.println("enter no of stairs to reach using 1 or 2 or 3 steps: ");
		Scanner n = new Scanner(System.in);
		System.out.println(count(n.nextInt()));
	}

}
