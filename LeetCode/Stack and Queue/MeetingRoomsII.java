public class Solution {
    public int meetingRooms (Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>()) {
            public int compare(Interval i1, Interval i2) {
                return (i1.start == i2.start) ? i1.end - i2.end : i1.start - i2.start;
            }
        });
        // total order 
        // intervals = [0, 2], [0, 5], [4,6]
        // pq=[5 ,2]
// <- ->        
// 0 1 2 3 4 5 6         
//   <------->
//         <-->  
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < pq.peek()) {
                pq.offer(intervals[i].end); 
            } else {
                pq.offer(intervals[i].end);
                pq.poll();
            }
        }
        return pq.size();
    }
}
   