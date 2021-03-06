/*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.


*/


//Solution

int Solution::maximumGap(const vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
   
   if(A.empty() || A.size() < 2)
                return 0;
    int maxNum = *max_element(A.begin(), A.end());
    int minNum = *min_element(A.begin(), A.end());
    //average gap from minNum to maxNum.
    int gap = (maxNum - minNum - 1) / (A.size() - 1) + 1;

    //number of buckets = num.size() - 1
    vector<int> bucketsMin(A.size() - 1, INT_MAX);
    vector<int> bucketsMax(A.size() - 1, INT_MIN);
    //put into buckets
    for (int i = 0; i < A.size(); i++) {
        if (A[i] != maxNum && A[i] != minNum)
        {
            int buckInd = (A[i] - minNum) / gap;
            bucketsMin[buckInd] = min(bucketsMin[buckInd], A[i]);
            bucketsMax[buckInd] = max(bucketsMax[buckInd], A[i]);
        }
    }
    int maxGap = INT_MIN;
    int previous = minNum;
    for (int i = 0; i < A.size() - 1; i++) {
      	if (bucketsMin[i] == INT_MAX && bucketsMax[i] == INT_MIN)
            continue;   //empty
        //i_th gap is minvalue in i+1_th bucket minus maxvalue in i_th bucket 
        maxGap = max(maxGap, bucketsMin[i] - previous);
        previous = bucketsMax[i];
    }
    maxGap = max(maxGap, maxNum - previous);
    return maxGap;
}
