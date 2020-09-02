 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        
    	ArrayList<Character> al = new ArrayList<Character>();

        for(int i = 0; i < s.length(); i++){
            
            if(al.size() > 0 && s.charAt(i) == al.get(al.size()-1)) {
                al.remove(al.size()-1);
            }
            else {
                al.add(s.charAt(i));
            }
        }
        String string = (al.size() == 0) ? "Empty String" : (al.toString() 
                .substring(1, 3 * al.size() - 1) 
                .replaceAll(", ", "")); 
        return string;
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./ReducedString.txt"));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
