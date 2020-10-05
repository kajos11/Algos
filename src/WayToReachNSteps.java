import java.util.Scanner;

/*
 * Count ways to reach the nth stair using step 1, 2
 */
public class WayToReachNSteps {
	static int calculateSteps(int n) {
		if(n <= 1) {
			return n;
		}
		
		return calculateSteps(n-1) + calculateSteps(n-2); 
	}
	static int getSteps(int n) {
		return calculateSteps(n+1);
	}
	public static void main(String[] args) {
		System.out.println("enter no of stairs to reach using 1 or 2 steps: ");
		Scanner n = new Scanner(System.in);
		System.out.println(getSteps(n.nextInt()));
	}

}
