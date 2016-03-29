/*
Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.

*/


//Solution


/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
int compareIntervals(Interval i1,Interval i2){
    return (i1.start<i2.start);
}
vector<Interval> Solution::merge(vector<Interval> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    vector<Interval> result;
    int i;
    sort(A.begin(),A.end(),compareIntervals);
    result.push_back(A[0]);
    for(i=1;i<A.size();i++){
        if(result.back().end<A[i].start)
        result.push_back(A[i]);
        else if(result.back().end<A[i].end)
        result.back().end=A[i].end;
    }
    return result;
}


