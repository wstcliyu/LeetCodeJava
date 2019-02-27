// http://www.zrzahid.com/maximum-number-of-overlapping-intervals/

import java.util.*;

public class Intervals {

//  Maximum number of overlapping intervals
/*
    Given a set of intervals, how do we find the maximum number of intervals overlapping at any point of time.

    For example – { (0,2), (3, 7), (4,6), (7,8), (1,5) }. The maximum number of intervals overlapped is 3 during (4,5).

    We can try sort! Notice that if there is no overlap then we will always see difference in number of start and number of end is equal to zero. 
    So, if an interval starts and if we increment a counter during a start and decrement the counter during an end then if there is no interval overlapped to this count is always zero. 
    This signals us a way to solve this problem i.e. sort the start and end points as separate arrays and count the overlaps by doing a merge operation on the two sorted arrays.

    Let’s consider all the start and end point as separate arrays.

    Sort starting points and ending points in ascending order separately. For example, s=[0, 1, 3, 4, 7] and end=[2, 5, 6, 7, 8].
    Do merge of start and end by maintaining two pointers i and j respectively in the two arrays.
    Keep track of the current overlap and maximum overlap we have seen so far during merge.
    Two cases
    If start[i] < end[i] : we know that a new range begins. So increment the current counter and update value of max counter. For example, we take first 2 starts , s=0,1 until we see an end, e = 2. so count=2.
    Otherwise : It’s an end point of a range so we decrement the counter. For example, when we see end point, e= 2 we update count = 2-1 = 1. And so on.
    At the end of this process, we have the answer in max counter.
    Here is a simple implementation of this approach in O(nlgn) time.
*/

    public static int maxOverlapIntervalCount(int[] start, int[] end){
        int maxOverlap = 0;
        int currentOverlap = 0;
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 0;
        int j = 0;
        int m = start.length; 
        int n = end.length;

        while(i < m && j < n){
            if(start[i] < end[j]){
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                i++;
            }
            else{
                currentOverlap--;
                j++;
            }
        }
        
        return maxOverlap;
    }









// Max CPU Load For Running Tasks
/*
    Another version of this problem could be –

    Given a list of n Jobs with start time, end time and CPU load when it is active at any moment. If all the jobs are running at the same machine then find the maximum CPU load at any time.

    For example, let’s define a job as a tuple of (start_time, end_time, weight) where weight is the load of that job at any time when active. Then,

    jobs = {(3, 7, 4), (1, 3, 6), (4, 9, 5)} –> max load = 10.
    jobs = {(3, 7, 4), (1, 3, 6), (4, 9, 5), (10, 11, 11)} –> max load = 11.
    jobs = {(3, 7, 4), (1, 3, 6), (4, 9, 5), (10, 11, 11),(3, 4, 2)} –> max load = 12.

    Note that, this is similar to finding maximum overlap where we maximize total weight (i.e. load) instead of maximizing total number of overlaps. 
    We can similarly sort the jobs based on start and end time in separate arrays and then find overlap incrementally as we did previously. 
    Each time we have one more overlapping interval we update current load with the current job and keep updating global max. 
    When we see an interval to end then we need to subtract the load of this job from the running load. 
    Below is a O(nlgn) time algorithm to find the max total load of all the jobs active at certain time.
*/
    class Job {
        int start, finish, weight;
    }

    public static int maxLoad(Job[] jobs){
        int maxLoad = 0;
        int curLoad = 0;
        
        Job[] start = Arrays.copyOf(jobs, jobs.length);
        Job[] end = Arrays.copyOf(jobs, jobs.length);
        
        Arrays.sort(start, new Comparator<Job>() {

            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Arrays.sort(end, new Comparator<Job>() {

            @Override
            public int compare(Job o1, Job o2) {
                return Integer.compare(o1.finish , o2.finish);
            }
        });
        
        int i = 0, j = 0;
        while(i < start.length && j < end.length){
            if(start[i].start <= end[j].finish){
                curLoad += start[i].weight;
                maxLoad = Math.max(maxLoad, curLoad);
                i++;
            }
            else{
                curLoad -= end[j].weight;
                j++;
            }
        }
        
        return maxLoad;
    }










// Insert a New Interval Into a Sorted Array Of Intervals
/*
    For Example, Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
    Also, [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]. 
    This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

    We can scan the sorted intervals from left to right and try to merge. There are 3 cases

    Case 1:New interval completely falls right side of current interval with no overlap. In this case current interval is taken and added to result as the new interval may get merged to other interval that starts after current interval.
    Case 2:New interval completely falls left side of current interval with no overlap. In this case new interval is taken and added to result as the it ends before current starts.
    Case 3:New interval overlaps with current interval. So, we will have a new interval that is a merged interval of current interval and new interval.
    The pseudocode for the above idea is as follows which takes O(n) time and O(1) space.
*/
    class Interval {
        int start, end;
        Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        for (Interval curInterval : intervals) {
            if (curInterval.end < newInterval.start) res.add(curInterval);
            else if (curInterval.start > newInterval.end) {
                res.add(newInterval);
                newInterval = curInterval;
            } 
            else {
                int start = Math.min(curInterval.start, newInterval.start);
                int end = Math.max(curInterval.end, newInterval.end);
                newInterval = new Interval(start, end);
            }
        }
        return res;
    }
}