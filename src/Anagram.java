
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	
    	int noOfRemovals = 0;
    	
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < a.length(); i++) {
            char curChar = a.charAt(i);
            if(map.containsKey(curChar)){
                int count = map.get(curChar);
                map.put(curChar, count+1);
            }
            else{
                map.put(curChar, 1);
            }
        }
        
        System.out.println(map);

        for(int j = 0; j < b.length(); j++){
            char curChar = b.charAt(j);
            
            if(map.get(curChar) == null || map.get(curChar) == 0){
                noOfRemovals++;
            }
            else{
                int count = map.get(curChar);
                map.put(curChar, count-1);
            }
            
        }
        
        for(int count : map.values()) {
        	noOfRemovals += count;
        }
        
        System.out.println(map);
        
        return noOfRemovals;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./anagram.txt"));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
