import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * 
 * https://leetcode.com/discuss/interview-question/374846/Twitter-or-OA-2019-or-University-Career-Fair
 * 
 * @author j0s
 *
 */
class Result {

    /*
     * Complete the 'maxEvents' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arrival
     *  2. INTEGER_ARRAY duration
     */
	/*
	 * 
17
978
409
229
934
299
982
636
14
866
815
64
537
426
670
116
95
630
17
502
518
196
106
405
452
299
189
124
506
883
753
567
717
338
439
145
	 */

    public static int maxEvents(List<Integer> arrival, List<Integer> duration) {
        // Write your code here
        int maxCount = 0;
        Map<Integer,Integer> arrived = new HashMap<Integer,Integer>();
        int minDuration = arrival.get(0);
        for(int i = 0 ; i < arrival.size(); i++){
        	if(arrived.get(arrival.get(i)) != null) {
        		if(duration.get(i)+arrival.get(i) < arrived.get(arrival.get(i))) {
        			minDuration =  duration.get(i)+arrival.get(i);
        			System.out.println("arrival2: "+arrival.get(i));
        			System.out.println("duration2: "+duration.get(i));
        			System.out.println("minDuration2: "+minDuration);
        			System.out.println("----");
//        			System.out.println("duration: "+duration.get(i));
//        			System.out.println("arrival: "+arrival.get(i));
//        			System.out.println("existing duration: "+arrived.get(arrival.get(i)));
        			arrived.put(arrival.get(i),minDuration);
        		}
        	}
        	else if(arrival.get(i) >= minDuration){
                maxCount += 1;
                minDuration = duration.get(i)+arrival.get(i);
                System.out.println("arrival1: "+arrival.get(i));
                System.out.println("duration1: "+duration.get(i));
                System.out.println("minDuration1: "+minDuration);
                System.out.println("----");
                arrived.put(arrival.get(i),minDuration);
            }
        }
        return maxCount;

    }

}

public class UniversityCareerFair {
	
	public static void sortList( List<Integer> arrival,  List<Integer> duration) {
		
		
		for(int i = 0 ; i < arrival.size()-1; i++) {
			for(int j = i+1; j < arrival.size(); j++) {
				if(arrival.get(i)+duration.get(i) >  arrival.get(j)+duration.get(j)) {
					int arrTemp = arrival.get(i);
					int durTemp = duration.get(i);
					arrival.set(i,arrival.get(j));
					duration.set(i,duration.get(j));
					arrival.set(j,arrTemp);
					duration.set(j,durTemp);
				}
			}
		}
		
		System.out.println(arrival);
		System.out.println(duration);
		
	}
	
    public static void main(String[] args) throws IOException {
		
		  BufferedReader bufferedReader = new BufferedReader(new
		  InputStreamReader(System.in)); BufferedWriter bufferedWriter = new
		  BufferedWriter(new FileWriter("test.txt"));
		  
		  int arrivalCount = Integer.parseInt(bufferedReader.readLine().trim());
		  
		  List<Integer> arrival = new ArrayList<>();
		  
		  for (int i = 0; i < arrivalCount; i++) { int arrivalItem =
		  Integer.parseInt(bufferedReader.readLine().trim()); arrival.add(arrivalItem);
		  }
		  
		  int durationCount = Integer.parseInt(bufferedReader.readLine().trim());
		  
		  List<Integer> duration = new ArrayList<>();
		  
		  for (int i = 0; i < durationCount; i++) { int durationItem =
		  Integer.parseInt(bufferedReader.readLine().trim());
		  duration.add(durationItem); }
		  
		  sortList(arrival, duration);
		  
		  int result = Result.maxEvents(arrival, duration);
		  
		  bufferedWriter.write(String.valueOf(result)); bufferedWriter.newLine();
		  
		  bufferedReader.close(); bufferedWriter.close();
		  
		 
        
        
        
    }
}



