/*

You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 


*/


//Solution

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
int repeatedNumber(const int* A, int n1) {

    int * keyArr = (int *)malloc(2*sizeof(int *));
    int * valueArr = (int *)malloc(2*sizeof(int *));
    int i;
    for(i=0;i<2;i++){
        keyArr[i]=-99999;
        valueArr[i]=-99999;
    }
    for(i=0;i<n1;i++){
        if(keyArr[0]==-99999 && A[i]!=keyArr[1]){
            keyArr[0]=A[i];
            valueArr[0]=1;
        }
        else if(keyArr[1]==-99999 && A[i]!=keyArr[0]){
            keyArr[1]=A[i];
            valueArr[1]=1;
        }
        else if(A[i]!=keyArr[0] && A[i]!=keyArr[1]){
            valueArr[0]=valueArr[0]-1;
            valueArr[1]=valueArr[1]-1;
            if(valueArr[0]==0){
                keyArr[0]=-99999;
                valueArr[0]=-99999;
            }
            if(valueArr[1]==0){
                keyArr[1]=-99999;
                valueArr[1]=-99999;
            }
        }
        else if(A[i]==keyArr[0]){
            valueArr[0]=valueArr[0]+1;
        }
        else if(A[i]==keyArr[1]){
            valueArr[1]=valueArr[1]+1;
        }
    }
    int count1=0,count2=0;
    if(keyArr[0]!=-99999||keyArr[1]!=-99999){
        for(i=0;i<n1;i++){
            if(keyArr[0]==A[i])
            count1++;
            if(keyArr[1]==A[i])
            count2++;
        }
        if(count1>(n1/3)){
            return keyArr[0];
        }
        else if(count2>(n1/3)){
            return keyArr[1];
        }
        else return -1;
    }
    else return -1;
}
