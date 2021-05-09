import java.util.Arrays;

/*

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

*/


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int totalMeetings = intervals.length;
        if(totalMeetings == 0) return 0;
        int[] startTimes = new int[totalMeetings];
        int[] endTimes = new int[totalMeetings];
        int k = 0;
        for(int i = 0;i<totalMeetings;i++){
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }
        Arrays.sort(startTimes);Arrays.sort(endTimes);
        int startTracker = 1 , endTracker = 0, rooms = 1, minRooms = 0;
        while(startTracker<totalMeetings && endTracker < totalMeetings){
            if(startTimes[startTracker]<endTimes[endTracker]){
                rooms++; startTracker++;
                if(rooms > minRooms)minRooms = rooms;
            }else{
                rooms--; endTracker++;
            }
        }
        return minRooms;
    }
}