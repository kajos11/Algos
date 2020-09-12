import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumTimeRequired {

    // Complete the minTime function below.
	//brute force
	
	/*
	 * static long minTime(long[] machines, long goal) { long[] temp =
	 * Arrays.copyOf(machines, machines.length); long tempGoal = 0; long day = 1;
	 * boolean goalMet = false; while(tempGoal < goal) { for(int i = 0; i <
	 * machines.length; i++) { temp[i] = temp[i]-1; if(temp[i] == 0) { tempGoal++;
	 * temp[i] = machines[i]; if(goal == tempGoal) { goalMet = true; } } }
	 * if(goalMet) { break; } day++; } return day; }
	 */
	// Complete the minTime function below.
	//optimized
    static long minTime(long[] machines, long goal) {
    	Arrays.sort(machines);
        long maxDays = machines[machines.length-1] * goal;
        long minDays = 0;
        long result = -1;
        while(minDays < maxDays) {
            long mid = (minDays+maxDays)/2;
            long sum = 0;
            for(long machine: machines) {
                sum += mid/machine;
            }
            if(sum < goal) {
                minDays = mid + 1;
            }
            else {
                maxDays = mid;
                result = mid;
            }
        }
        return result;
        
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./MinimumTimeRequiredOutput.txt"));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
