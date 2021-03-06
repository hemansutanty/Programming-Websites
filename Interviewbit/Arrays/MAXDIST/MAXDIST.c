/*


Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

If there is no solution possible, return -1.

Example :

A : [3 5 4 2]

Output : 2 
for the pair (3, 4)

*/



//Solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
int max(int a,int b){
    return a>b?a:b;
}
int min(int a,int b){
    return a<b?a:b;
}
int maximumGap(const int* A, int n1) {
    int *Lmin = (int*)malloc(n1*sizeof(int));
    int *Rmax = (int*)malloc(n1*sizeof(int));
    Lmin[0]=A[0];
    int i,j,maxDiff;
    for(i=1;i<n1;i++){
        Lmin[i]=min(A[i],Lmin[i-1]);
    }
    Rmax[n1-1]=A[n1-1];
    for(i=n1-2;i>=0;i--){
        Rmax[i]=max(A[i],Rmax[i+1]);
    }
    i=0;j=0;maxDiff=-1;
    while(i<n1 && j<n1){
        if(Lmin[i]<=Rmax[j]){
            maxDiff=max(maxDiff,j-i);
            j=j+1;
        }
        else{
            i=i+1;
        }
    }
    return maxDiff;
}
