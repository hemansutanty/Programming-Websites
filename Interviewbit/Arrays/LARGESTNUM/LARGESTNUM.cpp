/*

Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

*/



//solution

int myCompare(string X,string Y){
    string XY = X.append(Y);
    string YX = Y.append(X);
    
    return(XY.compare(YX)>0?1:0);
}
string Solution::largestNumber(const vector<int> &A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    vector<string> B;
    string result="";int i;
    for(i=0;i<A.size();i++){
        B.push_back(to_string(A[i]));
    }
    sort(B.begin(),B.end(),myCompare);
    for(i=0;i<B.size();i++){
        result+=B[i];
    }
    int allZeroes=1;
    for(i=0;i<result.length();i++)
    {
        if(result[i]!='0')
        allZeroes=0;
    }
    if(allZeroes==1)
    result="0";
    return result;
}
