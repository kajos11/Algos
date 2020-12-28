import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumPerimeterTrianglePerformance {

    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        //int[] result = maximumPerimeterTriangle(sticks);
        Arrays.sort(sticks);
        
        int i , j , k;
        
        for(i = n-3, j= n-2, k = n-1; sticks[i]+sticks[j] <= sticks[k]; i--,j--,k-- ){
            if(i == 0){
                System.out.println("out");
                bufferedWriter.write(-1+"");
                bufferedWriter.newLine();
                bufferedWriter.close();
                scanner.close();
                return;
            }
        }
        System.out.println("here");
        bufferedWriter.write(sticks[i]+" "+sticks[j]+" "+sticks[k]);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
