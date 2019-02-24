import java.util.*;

public class Meeting_253 {
	class Interval {
		int start, end;
	}

	// Standard solution #1: Priority Queue
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length == 0) return 0;

		PriorityQueue<Integer> allocator = new PriorityQueue<>();

		Arrays.sort(intervals, Comparator.comparing((Interval i) -> i.start));

		// Add the first meeting
		allocator.add(intervals[0].end);

	    // Iterate over remaining intervals
	    for (int i = 1; i < intervals.length; i++) {

	        // If the room due to free up the earliest is free, assign that room to this meeting.
	        if (intervals[i].start >= allocator.peek()) {
	        	allocator.poll();
	      	}

		    // If a new room is to be assigned, then also we add to the heap,
		    // If an old room is allocated, then also we have to add to the heap with updated end time.
		    allocator.add(intervals[i].end);
	    }

	    // The size of the heap tells us the minimum rooms required for all the meetings.
	    return allocator.size();
	}



	// Standard solution #2: Chronological Ordering
	/*
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length == 0) return 0;
		int N = intervals.length;
		int[] start = new int[N];
		int[] end = new int[N];
		for (int i = 0; i < N; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int usedRooms = 0;
		int startPointer = 0, endPointer = 0;
		while (startPointer < N) {
			if (start[startPointer] >= end[endPointer]) {
				usedRooms--;
				endPointer++;
			}
			usedRooms++;
			startPointer++;
		}
		return usedRooms;
	}
	*/
}