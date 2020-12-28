import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaximumPerimeter {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        int[] res = new int[3];
        int n = sticks.length;
        for(int i = 0 ; i < n-3; i++){
            int latest = i + 1;
            while(latest != n-1){
                int j = latest +1;
                while(j != n){
                	System.out.println(sticks[i]+","+sticks[latest]+","+sticks[j]);
                    if(((sticks[i] + sticks[latest]) > sticks[j])
                    && ((sticks[latest] + sticks[j]) > sticks[i])
                    && ((sticks[j] + sticks[i]) > sticks[latest])){
                        if(res[0] != 0 && res[1] != 0
                         && res[2] != 0
                         && (sticks[i] + sticks[latest] + sticks[j]) > 
                         (res[0] + res[1] + res[2])){
                        	System.out.println("updating latest: "+sticks[i] +"-"+ sticks[latest] +"-"+ sticks[j]);
                             res[0] = sticks[i];
                             res[1] = sticks[latest];
                             res[2] = sticks[j];
                         }
                        else if(res[0] == 0 && res[1] == 0
                                && res[2] == 0){
                        	System.out.println("setting latest"+sticks[i] +"-"+ sticks[latest] +"-"+ sticks[j]);
                                    res[0] = sticks[i];
                                    res[1] = sticks[latest];
                                    res[2] = sticks[j];
                        }
                    }
                    j += 1; 
                }
                latest += 1;
            }
        }
        return res;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("maxPer.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
