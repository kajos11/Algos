import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CommonChild {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	/* 
    	 * LCS Problem:
    	 * Used in Data comparison programs like DIFF Utility
    	 * Widely used in Revision control systems such as GIT for reconciling
    	 * multiple changes made to a revision controlled collection of files
    	 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
    	 * 
    	 */
    	
    	int[][] arr  = new int[s1.length()+1][s2.length()+1];
    	
    	for(int i = 0 ; i < s2.length(); i++) {
    		for(int j = 0 ; j < s1.length(); j++) {
    			
    			//First property: sum of top left cell + 1
    			if(s2.charAt(i) == s1.charAt(j)) {
    				arr[i+1][j+1] = arr[i][j]+1;
    			}
    			//Second property: max of top and left cell value
    			else {
    				arr[i+1][j+1] = Math.max(arr[i][j+1],arr[i+1][j]);
    			}
    			
    		}
    	}
    	return arr[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./CommonChildOutput.txt"));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
