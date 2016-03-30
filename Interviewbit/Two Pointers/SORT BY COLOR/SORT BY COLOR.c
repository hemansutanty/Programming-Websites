/*

Given an array with n objects colored red, white or blue,
sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: Using library sort function is not allowed.

Example :

Input : [0 1 2 0 1 2]
Modify array so that it becomes : [0 0 1 1 2 2]


*/



//Solution


/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void sortColors(int* A, int n1) {
    int i;
    int count[3];
    for(i=0;i<3;i++){
        count[i]=0;
    }
    for(i=0;i<n1;i++){
        count[A[i]]++;
    }
    int j = 0;
    int k = 0;
    while(j<=2){
        if(count[j]!=0){
            A[k++]=j;
            count[j] = count[j]-1;
        }else{
            j++;
        }
    }
}