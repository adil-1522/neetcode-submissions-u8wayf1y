/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0) return 0;

        intervals.sort((a,b)->a.start-b.start);

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(Interval interval: intervals){
            if(!q.isEmpty() && q.peek()<=interval.start){
                q.poll();
            }
            q.add(interval.end);
        }
        return q.size();
    }
}
