/*

Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003


*/


//Solution

#define MOD 1000003
void initializeFactorials(int totalLen, vector<int> &fact) {
    long long int factorial = 1;
    fact.push_back(1); // 0!= 1
    for (int curIndex = 1; curIndex < totalLen; curIndex++) {
        factorial = (factorial * curIndex) % MOD;
        fact.push_back(factorial);
    }
    return;
}
int Solution::findRank(string A) {
    
    int charCount[256]; // count of characters in S. 
    memset(charCount, 0, sizeof(charCount));
    for (int i = 0; i < A.length(); i++) charCount[A[i]]++;

    vector<int> fact; // fact[i] will contain i! % MOD
    initializeFactorials(A.length() + 1, fact);
	long long int rank =  1;
    for (int i = 0; i < A.length(); i++) {
        // find number of characters smaller than S[i] still left. 
        int less = 0;
        for (int ch = 0; ch < A[i]; ch++) {
            less += charCount[ch]; 
        }
        rank = (rank + ((long long)fact[A.length() - i - 1] * less)) % MOD;
        // remove the current character from the set. 
        charCount[A[i]]--;
    }
    return rank;
}


