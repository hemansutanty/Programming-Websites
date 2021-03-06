/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

*/


Solution

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
bool doesIntersect(Interval a, Interval b)
{
    if (min(a.end, b.end) < max(a.start, b.start)) 
        return false;
    return true;
}
vector<Interval> Solution::insert(vector<Interval> &intervals, Interval newInterval) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    int sz = intervals.size();
    vector<Interval> result; 
 
    // check corner cases
    // Case : Empty input array
    if (sz == 0)
    {
        result.push_back(newInterval);
        return result;
    }
    // Case : given comes at the beginning or at the end without overlap 
    if (newInterval.start > intervals[sz - 1].end || newInterval.end < intervals[0].start)
    {
        if (newInterval.end < intervals[0].start)
        {
            result.push_back(newInterval);
        }
        for (int i = 0; i < sz; i++)
        {
            result.push_back(intervals[i]);
        }
        if (newInterval.start > intervals[sz - 1].end)
        {
            result.push_back(newInterval);
        }
        return result;
    }
 
    for (int i = 0; i < sz; i++)
    {
        bool intersect = doesIntersect(intervals[i], newInterval);
        if (!intersect)
        {
            result.push_back(intervals[i]);
            // check if given lies between input[i] and input[i+1]
            if (i < sz - 1 && newInterval.start > intervals[i].end && newInterval.end < intervals[i+1].start)
            {
                result.push_back(newInterval);
            }
            continue;
        }
        // Now we know the pair overlaps. Lets find out how many input overlap. 
        int st = i; 
        while (i < sz && intersect)
        {
            i++;
            if (i == sz) 
                intersect = false; 
            else
            {
                intersect = doesIntersect(intervals[i], newInterval);
            }
        }
        i--;
        // Now all input from st to i overlap. 
        Interval toInsert(min(newInterval.start, intervals[st].start), max(newInterval.end, intervals[i].end));
        result.push_back(toInsert);
    }
    return result;
}
