import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialString{

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long count = n;
        for(int i = 0; i < n; i++){
            List<Character> t = new ArrayList<>();
            t.add(s.charAt(i));
            boolean isPotentialMiddle = false;
            for(int j = i+1; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && !isPotentialMiddle){
                    t.add(new Character(s.charAt(j)));
                    count++;
                }
                else if(s.charAt(i) != s.charAt(j) && !isPotentialMiddle){isPotentialMiddle = true;}
                else if(isPotentialMiddle && s.charAt(i) == s.charAt(j)){ t.remove(new Character(s.charAt(j))); if(t.size() == 0){ count++; break; } }
                else if(isPotentialMiddle && s.charAt(i) != s.charAt(j)){ break;}
            }
        }
        return count;    
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
		/*
		 * Scanner scanner = null; try { scanner = new Scanner(new BufferedReader(new
		 * FileReader("./SpecialStringInput.txt"))); } catch(Exception e) {
		 * e.printStackTrace(); }
		 */
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./SpecialStringOutput"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
