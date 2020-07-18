import java.util.ArrayList;
import java.util.List;

/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 

Note:

0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9

*/


class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[][]> resultList = new ArrayList<>();
        int apointer=0, bpointer = 0;
        while(apointer<A.length && bpointer<B.length){
            if(A[apointer][0]<=B[bpointer][1] && A[apointer][1]>=B[bpointer][0]){
                int[][] set = new int[1][2]; 
                set[0][0] = Math.max(A[apointer][0], B[bpointer][0]);
                set[0][1] = Math.min(A[apointer][1], B[bpointer][1]);
                resultList.add(set);
            }
            if(A[apointer][1]<B[bpointer][1]){
                apointer++;
            }else{
                bpointer++;
            }
        }
        int[][] result = new int[resultList.size()][2];
        for(int i =0;i<resultList.size();i++){
            result[i][0] = resultList.get(i)[0][0];result[i][1] = resultList.get(i)[0][1];
        }
        return result;
    }
}