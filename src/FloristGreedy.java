import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FloristGreedy {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        
    	int minCost = 0;
        int n = c.length;
        Arrays.sort(c);
        for(int i = n-k ; i < n; i++) {
            minCost += c[i];
        }
        int  l = 1;

        int count = k-1;
        for(int j = n-k-1; j >= 0; j--) {
        	minCost += ((l + 1) * c[j]);
        	count-=1;
        	if(count==0) {count = k;}
        	if (count == k-1) {
        		System.out.println(c[j]);
                l += 1;
          	}
        }
        
        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("greedyFlorist.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
