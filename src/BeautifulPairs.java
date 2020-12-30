import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BeautifulPairs {

    // Complete the beautifulPairs function below.
    static int beautifulPairs(int[] A, int[] B) {
        
        int count = 0;
        for(int i = 0 ; i < A.length; i++){
            for(int j = 0 ; j < B.length; j++){
                if(A[i] == B[j] && A[i] != -1 && B[j] != -1){
                    count++;
                    A[i] = -1;
                    B[j] = -1;
                    break;
                }
            }
        }
        print(A,B);
        System.out.println("count: "+count);
        System.out.println("A.length: "+A.length);
        return (count == A.length)? count-1 : count+1;
    }

    static void print(int[] A, int[] B) {
    	for(int i = 0 ; i < A.length; i++) {
    		System.out.println(A[i]+"-"+B[i]);
    	}
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("beautifulPairs.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
