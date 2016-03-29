/*

N number of books are given. 
The ith book has Pi number of pages. 
You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated atleast one book.

NOTE: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order.

Input:
 List of Books M number of students 

Your function should return an integer corresponding to the minimum number.

Example:

P : [12, 34, 67, 90]
M : 2

Output : 113

There are 2 number of students. Books can be distributed in following fashion : 
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.

*/


//Solution

bool isPossible(vector<int>  &arr, int n, int m, int curMin) {
   
    int studentsRequired = 1;
    int curSum = 0;
   
    for (int i = 0; i < n; i++) {
   
        if (arr[i] > curMin) return false;
   
        if (curSum + arr[i] > curMin) {
         
            studentsRequired++;
            curSum = arr[i]; 
            if (studentsRequired > m) return false;
        } 
        else {
            curSum += arr[i];
        }
    }
    return true;
}
int Solution::books(vector<int> &A, int B) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    long long sum = 0;
    if(A.size() < B) return -1;
 
    for(int i = 0; i < A.size(); ++i)  sum += A[i];
     
 
    long long start = 0;
    long long end = sum, mid;
    int ans = INT_MAX; 
    
    while(start <= end) {
         
        mid = (start + end) / 2;
         
        if (isPossible(A, A.size(), B, mid)) {
         
            ans = min(ans, (int)mid);
            end = mid - 1;
        } 
         
        else {
            start = mid + 1;
        }
    }
    return ans;
}
