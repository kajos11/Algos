import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ValleyCount {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int currentLevel = 0;
        int valleyCount = 0;
        for(int i = 0 ; i < n-1 ; i++){
            if(currentLevel == 0 && s.charAt(i) == 'D'){
                valleyCount += 1;
                System.out.println("valleyCoutn incresed: "+valleyCount);
                currentLevel -= 1; 
            }
            else if(s.charAt(i) == 'D') {
            	currentLevel -= 1;
            }
            else if(s.charAt(i) == 'U'){
                currentLevel += 1;
            }
            System.out.println("currentLevel: "+currentLevel+" char: "+s.charAt(i));
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./ans.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
