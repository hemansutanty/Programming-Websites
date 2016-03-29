/*

Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 Warning : DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points. 


 */


 //Solution

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void swap(int *a,int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}
void nextPermutation(int* A, int n1) {
    
    int i,k=-1,l=-1;
    for(i=0;i<n1-1;i++){
        if(A[i]<A[i+1]){
            k=i;
        }
    }
    for(i=k+1;i<n1;i++){
        if(A[k]<A[i]){
            l=i;
        }
    }
    if(k!=-1&&l!=-1){
        swap(&A[k],&A[l]);
        int begin=k+1,end=n1-1;
        while(begin<end)
        {swap(&A[begin],&A[end]);begin++;end--;}
    }
    else
    {
        int begin=0,end=n1-1;
        while(begin<end)
        {swap(&A[begin],&A[end]);begin++;end--;}
    }
}

 