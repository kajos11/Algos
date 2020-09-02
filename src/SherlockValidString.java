
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockValidString {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        int maxCount = 0;
        char[]  r = s.toCharArray();
        for(int i = 0 ; i < s.length(); i++) {
            if(charCounts.get(s.charAt(i)) != null){
                charCounts.put(s.charAt(i), (charCounts.get(s.charAt(i))+1));
                if(maxCount < (charCounts.get(s.charAt(i))+1)) {
                	maxCount = (charCounts.get(s.charAt(i))+1);
                }
            }
            else{
                charCounts.put(s.charAt(i), 1);
                if(maxCount < 1) {
                	maxCount = 1;
                }
            }
        }
        
        
        boolean isValid = true;
        int n1 = charCounts.get(s.charAt(0));
        for (int i : charCounts.values()) {
            if (i != n1) {
                isValid = false;
            }
        }

        if(isValid){
            return "YES";
        }
        
        
        for(int i = 0 ; i < s.length(); i++) {
        	isValid = true;
        	charCounts.put(s.charAt(i), charCounts.get(s.charAt(i))-1);
        	int n = charCounts.get(s.charAt(0));
        	for(int j : charCounts.values()) {
        		if(n != j && j > 0) {
        			isValid = false;
        		}
        	}
        	charCounts.put(s.charAt(i), charCounts.get(s.charAt(i))+1);
        	if(isValid) {
        		isValid = true;
        		break;
        	}
        }
        
        
        return isValid ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./SherlockResult.txt"));

        
        //String s = scanner.nextLine();
        String s = new BufferedReader(new FileReader("./shIn.txt")).readLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
