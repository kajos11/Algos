import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class IntervalScheduling {
	
	public static void main(String[] args) {
		int[] arrival1 = {14, 64, 95, 116, 229, 299, 409, 426, 537, 630, 636, 670, 815, 866, 934, 978, 982};
		int[] duration1 = {189, 883, 439, 338, 196, 405, 518, 567, 753, 145, 299, 717, 506, 124, 106, 502, 452};
		System.out.println(maxEvents(arrival1, duration1));
		/*
		 * int[] arrival2 = {1,3,3,5,7, 6, 9}; int[] duration2 = {2,2,1,2,1, 10, 2};
		 * System.out.println(maxEvents(arrival2, duration2));
		 */
	}
	private static void print(int[][] events, int eveOrDur) {
		for(int i=0; i < events.length;i++) {
			System.out.print(events[i][eveOrDur]+"-");
		}
		System.out.println();
	}
	private static int maxEvents(int[] arrival, int[] duration) {
		int[][] events = new int[arrival.length][2];
		for(int i=0;i<arrival.length;i++) {
			events[i] = new int[] {arrival[i], arrival[i] + duration[i]};
		}
		print(events,0);
		print(events,1);
		Arrays.sort(events, (a, b)->(a[1] - b[1]));
		print(events,0);
		print(events,1);
		Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
		int[] first = events[0];
		for(int i=1;i<events.length;i++) {
			int[] cur = events[i];
			if(cur[0] < first[1])
				minHeap.offer(cur);
			else {
				first[1] = events[i][1];
			}	
		}
		return arrival.length - minHeap.size();
	}

}
